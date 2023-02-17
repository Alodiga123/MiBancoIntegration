package com.alodiga.integretion.web.rest;

import com.alodiga.integretion.repository.RencimientoRepository;
import com.alodiga.integretion.service.RencimientoService;
import com.alodiga.integretion.service.dto.RencimientoDTO;
import com.alodiga.integretion.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.alodiga.integretion.domain.Rencimiento}.
 */
@RestController
@RequestMapping("/api")
public class RencimientoResource {

    private final Logger log = LoggerFactory.getLogger(RencimientoResource.class);

    private static final String ENTITY_NAME = "rencimiento";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RencimientoService rencimientoService;

    private final RencimientoRepository rencimientoRepository;

    public RencimientoResource(RencimientoService rencimientoService, RencimientoRepository rencimientoRepository) {
        this.rencimientoService = rencimientoService;
        this.rencimientoRepository = rencimientoRepository;
    }

    /**
     * {@code POST  /rencimientos} : Create a new rencimiento.
     *
     * @param rencimientoDTO the rencimientoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new rencimientoDTO, or with status {@code 400 (Bad Request)} if the rencimiento has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/rencimientos")
    public Mono<ResponseEntity<RencimientoDTO>> createRencimiento(@Valid @RequestBody RencimientoDTO rencimientoDTO)
        throws URISyntaxException {
        log.debug("REST request to save Rencimiento : {}", rencimientoDTO);
        if (rencimientoDTO.getId() != null) {
            throw new BadRequestAlertException("A new rencimiento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return rencimientoService
            .save(rencimientoDTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/rencimientos/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /rencimientos/:id} : Updates an existing rencimiento.
     *
     * @param id the id of the rencimientoDTO to save.
     * @param rencimientoDTO the rencimientoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rencimientoDTO,
     * or with status {@code 400 (Bad Request)} if the rencimientoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the rencimientoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/rencimientos/{id}")
    public Mono<ResponseEntity<RencimientoDTO>> updateRencimiento(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody RencimientoDTO rencimientoDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Rencimiento : {}, {}", id, rencimientoDTO);
        if (rencimientoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, rencimientoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return rencimientoRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return rencimientoService
                    .update(rencimientoDTO)
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
     * {@code PATCH  /rencimientos/:id} : Partial updates given fields of an existing rencimiento, field will ignore if it is null
     *
     * @param id the id of the rencimientoDTO to save.
     * @param rencimientoDTO the rencimientoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rencimientoDTO,
     * or with status {@code 400 (Bad Request)} if the rencimientoDTO is not valid,
     * or with status {@code 404 (Not Found)} if the rencimientoDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the rencimientoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/rencimientos/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<RencimientoDTO>> partialUpdateRencimiento(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody RencimientoDTO rencimientoDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Rencimiento partially : {}, {}", id, rencimientoDTO);
        if (rencimientoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, rencimientoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return rencimientoRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<RencimientoDTO> result = rencimientoService.partialUpdate(rencimientoDTO);

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
     * {@code GET  /rencimientos} : get all the rencimientos.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of rencimientos in body.
     */
    @GetMapping("/rencimientos")
    public Mono<ResponseEntity<List<RencimientoDTO>>> getAllRencimientos(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of Rencimientos");
        return rencimientoService
            .countAll()
            .zipWith(rencimientoService.findAll(pageable).collectList())
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
     * {@code GET  /rencimientos/:id} : get the "id" rencimiento.
     *
     * @param id the id of the rencimientoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rencimientoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/rencimientos/{id}")
    public Mono<ResponseEntity<RencimientoDTO>> getRencimiento(@PathVariable Long id) {
        log.debug("REST request to get Rencimiento : {}", id);
        Mono<RencimientoDTO> rencimientoDTO = rencimientoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(rencimientoDTO);
    }

    /**
     * {@code DELETE  /rencimientos/:id} : delete the "id" rencimiento.
     *
     * @param id the id of the rencimientoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/rencimientos/{id}")
    public Mono<ResponseEntity<Void>> deleteRencimiento(@PathVariable Long id) {
        log.debug("REST request to delete Rencimiento : {}", id);
        return rencimientoService
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
