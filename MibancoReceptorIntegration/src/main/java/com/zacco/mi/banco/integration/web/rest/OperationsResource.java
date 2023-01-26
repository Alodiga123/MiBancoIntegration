package com.zacco.mi.banco.integration.web.rest;

import com.alodiga.transaction.gateway.integration.methods.TransactionGateway;
import com.alodiga.transaction.gateway.integration.response.PostRechargeResponse;
import com.zacco.mi.banco.integration.domain.Operations;
import com.zacco.mi.banco.integration.operationdto.OperationDTO;
import com.zacco.mi.banco.integration.repository.OperationsRepository;
import com.zacco.mi.banco.integration.response.Response;
import com.zacco.mi.banco.integration.service.OperationsQueryService;
import com.zacco.mi.banco.integration.service.OperationsService;
import com.zacco.mi.banco.integration.service.criteria.OperationsCriteria;
import com.zacco.mi.banco.integration.web.rest.errors.BadRequestAlertException;
import com.zacco.mi.banco.util.Constants;
import com.zacco.mi.banco.util.Util;
import static com.zacco.mi.banco.util.Util.first_Chars;
import static com.zacco.mi.banco.util.Util.remove_first_Char;
import static com.zacco.mi.banco.util.Util.removerZeroPhone;
import static com.zacco.mi.banco.util.Util.type_Document_Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.zacco.mi.banco.integration.domain.Operations}.
 */
@RestController
@RequestMapping("/api")
public class OperationsResource {

    private final Logger log = LoggerFactory.getLogger(OperationsResource.class);

    private static final String ENTITY_NAME = "operations";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OperationsService operationsService;

    private final OperationsRepository operationsRepository;

    private final OperationsQueryService operationsQueryService;

    public OperationsResource(
        OperationsService operationsService,
        OperationsRepository operationsRepository,
        OperationsQueryService operationsQueryService
    ) {
        this.operationsService = operationsService;
        this.operationsRepository = operationsRepository;
        this.operationsQueryService = operationsQueryService;
    }

    /**
     * {@code POST  /operations} : Create a new operations.
     *
     * @param operations the operations to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new operations, or with status {@code 400 (Bad Request)} if the operations has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/operations")
    public ResponseEntity<Response> createOperations(@RequestBody OperationDTO operations) throws URISyntaxException, Exception {
        log.debug("REST request to save Operations : {}", operations);
        Response response = new Response();
        String type_document = first_Chars(operations.getCedulaBeneficiario());
        if (!type_Document_Valid(type_document)) {            
            Operations operation = new Operations(operations.getCedulaBeneficiario(), operations.getTelefonoEmisor(),
                    operations.getTelefonoBeneficiario(), operations.getMonto(), operations.getBancoEmisor(),
                    operations.getConcepto(), operations.getReferencia(), operations.getFechaHora(), false, Constants.INVALID_NACIONALITY);
            operationsRepository.save(operation);
            log.debug("Object: {}", operation);
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
        if (Float.parseFloat(operations.getMonto()) <= Constants.AMOUNT_MIN_DEPOSIT) {
            Operations operation = new Operations(operations.getCedulaBeneficiario(), operations.getTelefonoEmisor(),
                    operations.getTelefonoBeneficiario(), operations.getMonto(), operations.getBancoEmisor(),
                    operations.getConcepto(), operations.getReferencia(), operations.getFechaHora(), false, Constants.MINIMUM_AMOUNT);
            operationsRepository.save(operation); 
            log.debug("Object: {}", operation);
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
        boolean validar = valid(operations);
        if (!validar) {            
            Operations operation = new Operations(operations.getCedulaBeneficiario(), operations.getTelefonoEmisor(),
                    operations.getTelefonoBeneficiario(), operations.getMonto(), operations.getBancoEmisor(),
                    operations.getConcepto(), operations.getReferencia(), operations.getFechaHora(), false, Constants.IS_REQUIRED);
            operationsRepository.save(operation);    
            log.debug("Object: {}", operation);
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
        String FechaOperacion = Util.InstantDateFormatedDate(operations.getFechaHora());
        PostRechargeResponse operationZacco = TransactionGateway.RechargeIntegrationP2P(6000, remove_first_Char(operations.getCedulaBeneficiario()),
                removerZeroPhone(operations.getTelefonoEmisor()), removerZeroPhone(operations.getTelefonoBeneficiario()), Float.valueOf(operations.getMonto()),
                operations.getBancoEmisor(), operations.getConcepto(), operations.getReferencia(), FechaOperacion);

        if (!"00".equals(operationZacco.getResponseData().getCodigoRespuesta())) {
            Operations operation = new Operations(operations.getCedulaBeneficiario(), operations.getTelefonoEmisor(),
                    operations.getTelefonoBeneficiario(), operations.getMonto(), operations.getBancoEmisor(),
                    operations.getConcepto(), operations.getReferencia(), operations.getFechaHora(), false, Constants.UNREGISTERED_USER);
            operationsRepository.save(operation);
            log.debug("Object: {}", operation);
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
        try {
            //Transaccion realizada
            Operations operation = new Operations(operations.getCedulaBeneficiario(), operations.getTelefonoEmisor(),
                    operations.getTelefonoBeneficiario(), operations.getMonto(), operations.getBancoEmisor(),
                    operations.getConcepto(), operations.getReferencia(), operations.getFechaHora(), true, Constants.SUCCESSFUL);
            operationsRepository.save(operation);
            log.debug("Object: {}", operation);

        } catch (Exception e) {            
            response.setSuccess(false);
            return ResponseEntity.badRequest().body(response);
        }
        response.setSuccess(true);
        return ResponseEntity.ok().body(response);
    }

    /**
     * {@code PUT  /operations/:id} : Updates an existing operations.
     *
     * @param id the id of the operations to save.
     * @param operations the operations to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operations,
     * or with status {@code 400 (Bad Request)} if the operations is not valid,
     * or with status {@code 500 (Internal Server Error)} if the operations couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/operations/{id}")
    public ResponseEntity<Operations> updateOperations(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody Operations operations
    ) throws URISyntaxException {
        log.debug("REST request to update Operations : {}, {}", id, operations);
        if (operations.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, operations.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!operationsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Operations result = operationsService.update(operations);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, operations.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /operations/:id} : Partial updates given fields of an existing operations, field will ignore if it is null
     *
     * @param id the id of the operations to save.
     * @param operations the operations to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operations,
     * or with status {@code 400 (Bad Request)} if the operations is not valid,
     * or with status {@code 404 (Not Found)} if the operations is not found,
     * or with status {@code 500 (Internal Server Error)} if the operations couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/operations/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Operations> partialUpdateOperations(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody Operations operations
    ) throws URISyntaxException {
        log.debug("REST request to partial update Operations partially : {}, {}", id, operations);
        if (operations.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, operations.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!operationsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Operations> result = operationsService.partialUpdate(operations);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, operations.getId().toString())
        );
    }

    /**
     * {@code GET  /operations} : get all the operations.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of operations in body.
     */
    @GetMapping("/operations")
    public ResponseEntity<List<Operations>> getAllOperations(
        OperationsCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Operations by criteria: {}", criteria);
        Page<Operations> page = operationsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /operations/count} : count all the operations.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/operations/count")
    public ResponseEntity<Long> countOperations(OperationsCriteria criteria) {
        log.debug("REST request to count Operations by criteria: {}", criteria);
        return ResponseEntity.ok().body(operationsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /operations/:id} : get the "id" operations.
     *
     * @param id the id of the operations to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the operations, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/operations/{id}")
    public ResponseEntity<Operations> getOperations(@PathVariable Long id) {
        log.debug("REST request to get Operations : {}", id);
        Optional<Operations> operations = operationsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(operations);
    }

    /**
     * {@code DELETE  /operations/:id} : delete the "id" operations.
     *
     * @param id the id of the operations to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/operations/{id}")
    public ResponseEntity<Void> deleteOperations(@PathVariable Long id) {
        log.debug("REST request to delete Operations : {}", id);
        operationsService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    private Boolean valid(OperationDTO o){
           
      return !(o.getCedulaBeneficiario() == null || o.getCedulaBeneficiario().equals(" ") || o.getCedulaBeneficiario().isBlank() || o.getCedulaBeneficiario().isEmpty() ||
              o.getTelefonoBeneficiario() == null || o.getTelefonoEmisor().equals(" ") || o.getTelefonoEmisor().isBlank() || o.getTelefonoEmisor().isEmpty() ||
              o.getTelefonoBeneficiario() == null || o.getTelefonoBeneficiario().equals(" ") || o.getTelefonoBeneficiario().isBlank() || o.getTelefonoBeneficiario().isEmpty() ||
              o.getMonto() == null || o.getMonto().equals(" ") || o.getMonto().isBlank() || o.getMonto().isEmpty() || 
              o.getBancoEmisor() == null || o.getBancoEmisor().equals(" ") || o.getBancoEmisor().isBlank() || o.getBancoEmisor().isEmpty() ||
              o.getConcepto() == null || o.getConcepto().equals(" ") || o.getConcepto().isBlank() || o.getConcepto().isEmpty() ||
              o.getReferencia() == null || o.getReferencia().equals(" ") || o.getReferencia().isBlank() || o.getReferencia().isEmpty() ||
              o.getFechaHora() == null || o.getFechaHora().equals(" ") || o.getFechaHora().isBlank() || o.getFechaHora().isEmpty());

        
    } 
}
