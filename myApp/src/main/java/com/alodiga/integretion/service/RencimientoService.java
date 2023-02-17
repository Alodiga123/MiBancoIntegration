package com.alodiga.integretion.service;

import com.alodiga.integretion.domain.Rencimiento;
import com.alodiga.integretion.repository.RencimientoRepository;
import com.alodiga.integretion.service.dto.RencimientoDTO;
import com.alodiga.integretion.service.mapper.RencimientoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link Rencimiento}.
 */
@Service
@Transactional
public class RencimientoService {

    private final Logger log = LoggerFactory.getLogger(RencimientoService.class);

    private final RencimientoRepository rencimientoRepository;

    private final RencimientoMapper rencimientoMapper;

    public RencimientoService(RencimientoRepository rencimientoRepository, RencimientoMapper rencimientoMapper) {
        this.rencimientoRepository = rencimientoRepository;
        this.rencimientoMapper = rencimientoMapper;
    }

    /**
     * Save a rencimiento.
     *
     * @param rencimientoDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<RencimientoDTO> save(RencimientoDTO rencimientoDTO) {
        log.debug("Request to save Rencimiento : {}", rencimientoDTO);
        return rencimientoRepository.save(rencimientoMapper.toEntity(rencimientoDTO)).map(rencimientoMapper::toDto);
    }

    /**
     * Update a rencimiento.
     *
     * @param rencimientoDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<RencimientoDTO> update(RencimientoDTO rencimientoDTO) {
        log.debug("Request to update Rencimiento : {}", rencimientoDTO);
        return rencimientoRepository.save(rencimientoMapper.toEntity(rencimientoDTO)).map(rencimientoMapper::toDto);
    }

    /**
     * Partially update a rencimiento.
     *
     * @param rencimientoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<RencimientoDTO> partialUpdate(RencimientoDTO rencimientoDTO) {
        log.debug("Request to partially update Rencimiento : {}", rencimientoDTO);

        return rencimientoRepository
            .findById(rencimientoDTO.getId())
            .map(existingRencimiento -> {
                rencimientoMapper.partialUpdate(existingRencimiento, rencimientoDTO);

                return existingRencimiento;
            })
            .flatMap(rencimientoRepository::save)
            .map(rencimientoMapper::toDto);
    }

    /**
     * Get all the rencimientos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<RencimientoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Rencimientos");
        return rencimientoRepository.findAllBy(pageable).map(rencimientoMapper::toDto);
    }

    /**
     * Returns the number of rencimientos available.
     * @return the number of entities in the database.
     *
     */
    public Mono<Long> countAll() {
        return rencimientoRepository.count();
    }

    /**
     * Get one rencimiento by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Mono<RencimientoDTO> findOne(Long id) {
        log.debug("Request to get Rencimiento : {}", id);
        return rencimientoRepository.findById(id).map(rencimientoMapper::toDto);
    }

    /**
     * Delete the rencimiento by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Rencimiento : {}", id);
        return rencimientoRepository.deleteById(id);
    }
}
