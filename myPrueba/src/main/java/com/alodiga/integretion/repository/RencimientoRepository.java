package com.alodiga.integretion.repository;

import com.alodiga.integretion.domain.Rencimiento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Rencimiento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RencimientoRepository extends ReactiveCrudRepository<Rencimiento, Long>, RencimientoRepositoryInternal {
    Flux<Rencimiento> findAllBy(Pageable pageable);

    @Override
    <S extends Rencimiento> Mono<S> save(S entity);

    @Override
    Flux<Rencimiento> findAll();

    @Override
    Mono<Rencimiento> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface RencimientoRepositoryInternal {
    <S extends Rencimiento> Mono<S> save(S entity);

    Flux<Rencimiento> findAllBy(Pageable pageable);

    Flux<Rencimiento> findAll();

    Mono<Rencimiento> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Rencimiento> findAllBy(Pageable pageable, Criteria criteria);

}
