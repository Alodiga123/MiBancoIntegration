package com.alodiga.integretion.service.mapper;

import com.alodiga.integretion.domain.Rencimiento;
import com.alodiga.integretion.service.dto.RencimientoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Rencimiento} and its DTO {@link RencimientoDTO}.
 */
@Mapper(componentModel = "spring")
public interface RencimientoMapper extends EntityMapper<RencimientoDTO, Rencimiento> {}
