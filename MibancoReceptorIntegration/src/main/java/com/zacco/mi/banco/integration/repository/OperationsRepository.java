package com.zacco.mi.banco.integration.repository;

import com.zacco.mi.banco.integration.domain.Operations;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Operations entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OperationsRepository extends JpaRepository<Operations, Long>, JpaSpecificationExecutor<Operations> {}
