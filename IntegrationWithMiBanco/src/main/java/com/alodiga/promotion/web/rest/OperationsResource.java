package com.alodiga.promotion.web.rest;

import com.alodiga.promotion.repository.OperationsRepository;
import com.alodiga.promotion.service.OperationsService;
import com.alodiga.promotion.service.dto.OperationsDTO;
import com.alodiga.promotion.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link com.alodiga.promotion.domain.Operations}.
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

    public OperationsResource(OperationsService operationsService, OperationsRepository operationsRepository) {
        this.operationsService = operationsService;
        this.operationsRepository = operationsRepository;
    }

    /**
     * {@code POST  /operations} : Create a new operations.
     *
     * @param operationsDTO the operationsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new operationsDTO, or with status {@code 400 (Bad Request)} if the operations has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/operations")
    public Mono<ResponseEntity<OperationsDTO>> createOperations(@Valid @RequestBody OperationsDTO operationsDTO) throws URISyntaxException {
        log.debug("REST request to save Operations : {}", operationsDTO);
        if (operationsDTO.getId() != null) {
            throw new BadRequestAlertException("A new operations cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return operationsService
            .save(operationsDTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/operations/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /operations/:id} : Updates an existing operations.
     *
     * @param id the id of the operationsDTO to save.
     * @param operationsDTO the operationsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operationsDTO,
     * or with status {@code 400 (Bad Request)} if the operationsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the operationsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/operations/{id}")
    public Mono<ResponseEntity<OperationsDTO>> updateOperations(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody OperationsDTO operationsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Operations : {}, {}", id, operationsDTO);
        if (operationsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, operationsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return operationsRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return operationsService
                    .update(operationsDTO)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /operations/:id} : Partial updates given fields of an existing operations, field will ignore if it is null
     *
     * @param id the id of the operationsDTO to save.
     * @param operationsDTO the operationsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operationsDTO,
     * or with status {@code 400 (Bad Request)} if the operationsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the operationsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the operationsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/operations/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<OperationsDTO>> partialUpdateOperations(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody OperationsDTO operationsDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Operations partially : {}, {}", id, operationsDTO);
        if (operationsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, operationsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return operationsRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<OperationsDTO> result = operationsService.partialUpdate(operationsDTO);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, res.getId().toString()))
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /operations} : get all the operations.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of operations in body.
     */
    @GetMapping("/operations")
    public Mono<ResponseEntity<List<OperationsDTO>>> getAllOperations(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of Operations");
        return operationsService
            .countAll()
            .zipWith(operationsService.findAll(pageable).collectList())
            .map(countWithEntities ->
                ResponseEntity
                    .ok()
                    .headers(
                        PaginationUtil.generatePaginationHttpHeaders(
                            UriComponentsBuilder.fromHttpRequest(request),
                            new PageImpl<>(countWithEntities.getT2(), pageable, countWithEntities.getT1())
                        )
                    )
                    .body(countWithEntities.getT2())
            );
    }

    /**
     * {@code GET  /operations/:id} : get the "id" operations.
     *
     * @param id the id of the operationsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the operationsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/operations/{id}")
    public Mono<ResponseEntity<OperationsDTO>> getOperations(@PathVariable Long id) {
        log.debug("REST request to get Operations : {}", id);
        Mono<OperationsDTO> operationsDTO = operationsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(operationsDTO);
    }

    /**
     * {@code DELETE  /operations/:id} : delete the "id" operations.
     *
     * @param id the id of the operationsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/operations/{id}")
    public Mono<ResponseEntity<Void>> deleteOperations(@PathVariable Long id) {
        log.debug("REST request to delete Operations : {}", id);
        return operationsService
            .delete(id)
            .then(
                Mono.just(
                    ResponseEntity
                        .noContent()
                        .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                        .build()
                )
            );
    }
}
