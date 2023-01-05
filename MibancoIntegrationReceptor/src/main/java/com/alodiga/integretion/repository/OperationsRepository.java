package com.alodiga.integretion.repository;

import com.alodiga.integretion.domain.Operations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Operations entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OperationsRepository extends ReactiveCrudRepository<Operations, Long>, OperationsRepositoryInternal {
    Flux<Operations> findAllBy(Pageable pageable);

    @Override
    <S extends Operations> Mono<S> save(S entity);

    @Override
    Flux<Operations> findAll();

    @Override
    Mono<Operations> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface OperationsRepositoryInternal {
    <S extends Operations> Mono<S> save(S entity);

    Flux<Operations> findAllBy(Pageable pageable);

    Flux<Operations> findAll();

    Mono<Operations> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Operations> findAllBy(Pageable pageable, Criteria criteria);

}
