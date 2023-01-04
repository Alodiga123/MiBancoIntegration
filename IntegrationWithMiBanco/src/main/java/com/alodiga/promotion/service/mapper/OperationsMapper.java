package com.alodiga.promotion.service.mapper;

import com.alodiga.promotion.domain.Operations;
import com.alodiga.promotion.service.dto.OperationsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Operations} and its DTO {@link OperationsDTO}.
 */
@Mapper(componentModel = "spring")
public interface OperationsMapper extends EntityMapper<OperationsDTO, Operations> {}
