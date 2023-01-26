package com.zacco.mi.banco.integration.service;

import com.zacco.mi.banco.integration.domain.*; // for static metamodels
import com.zacco.mi.banco.integration.domain.Operations;
import com.zacco.mi.banco.integration.repository.OperationsRepository;
import com.zacco.mi.banco.integration.service.criteria.OperationsCriteria;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Operations} entities in the database.
 * The main input is a {@link OperationsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Operations} or a {@link Page} of {@link Operations} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class OperationsQueryService extends QueryService<Operations> {

    private final Logger log = LoggerFactory.getLogger(OperationsQueryService.class);

    private final OperationsRepository operationsRepository;

    public OperationsQueryService(OperationsRepository operationsRepository) {
        this.operationsRepository = operationsRepository;
    }

    /**
     * Return a {@link List} of {@link Operations} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Operations> findByCriteria(OperationsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Operations> specification = createSpecification(criteria);
        return operationsRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Operations} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Operations> findByCriteria(OperationsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Operations> specification = createSpecification(criteria);
        return operationsRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(OperationsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Operations> specification = createSpecification(criteria);
        return operationsRepository.count(specification);
    }

    /**
     * Function to convert {@link OperationsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Operations> createSpecification(OperationsCriteria criteria) {
        Specification<Operations> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Operations_.id));
            }
            if (criteria.getCedulaBeneficiario() != null) {
                specification =
                    specification.and(buildStringSpecification(criteria.getCedulaBeneficiario(), Operations_.cedulaBeneficiario));
            }
            if (criteria.getTelefonoEmisor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTelefonoEmisor(), Operations_.telefonoEmisor));
            }
            if (criteria.getTelefonoBeneficiario() != null) {
                specification =
                    specification.and(buildStringSpecification(criteria.getTelefonoBeneficiario(), Operations_.telefonoBeneficiario));
            }
            if (criteria.getMonto() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMonto(), Operations_.monto));
            }
            if (criteria.getBancoEmisor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBancoEmisor(), Operations_.bancoEmisor));
            }
            if (criteria.getConcepto() != null) {
                specification = specification.and(buildStringSpecification(criteria.getConcepto(), Operations_.concepto));
            }
            if (criteria.getReferencia() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferencia(), Operations_.referencia));
            }
            if (criteria.getFechaHora() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFechaHora(), Operations_.fechaHora));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getStatus(), Operations_.status));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Operations_.description));
            }
        }
        return specification;
    }
}
