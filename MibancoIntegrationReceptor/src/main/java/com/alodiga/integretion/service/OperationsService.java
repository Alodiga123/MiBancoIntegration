package com.alodiga.integretion.service;

import com.alodiga.integretion.domain.Operations;
import com.alodiga.integretion.repository.OperationsRepository;
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

    public OperationsService(OperationsRepository operationsRepository) {
        this.operationsRepository = operationsRepository;
    }

    /**
     * Save a operations.
     *
     * @param operations the entity to save.
     * @return the persisted entity.
     */
    public Mono<Operations> save(Operations operations) {
        log.debug("Request to save Operations : {}", operations);
        return operationsRepository.save(operations);
    }

    /**
     * Update a operations.
     *
     * @param operations the entity to save.
     * @return the persisted entity.
     */
    public Mono<Operations> update(Operations operations) {
        log.debug("Request to update Operations : {}", operations);
        return operationsRepository.save(operations);
    }

    /**
     * Partially update a operations.
     *
     * @param operations the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<Operations> partialUpdate(Operations operations) {
        log.debug("Request to partially update Operations : {}", operations);

        return operationsRepository
            .findById(operations.getId())
            .map(existingOperations -> {
                if (operations.getCedulaBeneficiario() != null) {
                    existingOperations.setCedulaBeneficiario(operations.getCedulaBeneficiario());
                }
                if (operations.getTelefonoEmisor() != null) {
                    existingOperations.setTelefonoEmisor(operations.getTelefonoEmisor());
                }
                if (operations.getTelefonoBeneficiario() != null) {
                    existingOperations.setTelefonoBeneficiario(operations.getTelefonoBeneficiario());
                }
                if (operations.getMonto() != null) {
                    existingOperations.setMonto(operations.getMonto());
                }
                if (operations.getBancoEmisor() != null) {
                    existingOperations.setBancoEmisor(operations.getBancoEmisor());
                }
                if (operations.getConcepto() != null) {
                    existingOperations.setConcepto(operations.getConcepto());
                }
                if (operations.getReferencia() != null) {
                    existingOperations.setReferencia(operations.getReferencia());
                }
                if (operations.getFechaHora() != null) {
                    existingOperations.setFechaHora(operations.getFechaHora());
                }

                return existingOperations;
            })
            .flatMap(operationsRepository::save);
    }

    /**
     * Get all the operations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<Operations> findAll(Pageable pageable) {
        log.debug("Request to get all Operations");
        return operationsRepository.findAllBy(pageable);
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
    public Mono<Operations> findOne(Long id) {
        log.debug("Request to get Operations : {}", id);
        return operationsRepository.findById(id);
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
