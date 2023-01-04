package com.alodiga.promotion.service;

import com.alodiga.promotion.domain.Operations;
import com.alodiga.promotion.repository.OperationsRepository;
import com.alodiga.promotion.service.dto.OperationsDTO;
import com.alodiga.promotion.service.mapper.OperationsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link Operations}.
 */
@Service
@Transactional
public class OperationsService {

    private final Logger log = LoggerFactory.getLogger(OperationsService.class);

    private final OperationsRepository operationsRepository;

    private final OperationsMapper operationsMapper;

    public OperationsService(OperationsRepository operationsRepository, OperationsMapper operationsMapper) {
        this.operationsRepository = operationsRepository;
        this.operationsMapper = operationsMapper;
    }

    /**
     * Save a operations.
     *
     * @param operationsDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<OperationsDTO> save(OperationsDTO operationsDTO) {
        log.debug("Request to save Operations : {}", operationsDTO);
        return operationsRepository.save(operationsMapper.toEntity(operationsDTO)).map(operationsMapper::toDto);
    }

    /**
     * Update a operations.
     *
     * @param operationsDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<OperationsDTO> update(OperationsDTO operationsDTO) {
        log.debug("Request to update Operations : {}", operationsDTO);
        return operationsRepository.save(operationsMapper.toEntity(operationsDTO)).map(operationsMapper::toDto);
    }

    /**
     * Partially update a operations.
     *
     * @param operationsDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<OperationsDTO> partialUpdate(OperationsDTO operationsDTO) {
        log.debug("Request to partially update Operations : {}", operationsDTO);

        return operationsRepository
            .findById(operationsDTO.getId())
            .map(existingOperations -> {
                operationsMapper.partialUpdate(existingOperations, operationsDTO);

                return existingOperations;
            })
            .flatMap(operationsRepository::save)
            .map(operationsMapper::toDto);
    }

    /**
     * Get all the operations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<OperationsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Operations");
        return operationsRepository.findAllBy(pageable).map(operationsMapper::toDto);
    }

    /**
     * Returns the number of operations available.
     * @return the number of entities in the database.
     *
     */
    public Mono<Long> countAll() {
        return operationsRepository.count();
    }

    /**
     * Get one operations by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Mono<OperationsDTO> findOne(Long id) {
        log.debug("Request to get Operations : {}", id);
        return operationsRepository.findById(id).map(operationsMapper::toDto);
    }

    /**
     * Delete the operations by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Operations : {}", id);
        return operationsRepository.deleteById(id);
    }
}
