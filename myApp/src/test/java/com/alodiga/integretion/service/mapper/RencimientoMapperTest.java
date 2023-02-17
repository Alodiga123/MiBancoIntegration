package com.alodiga.integretion.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RencimientoMapperTest {

    private RencimientoMapper rencimientoMapper;

    @BeforeEach
    public void setUp() {
        rencimientoMapper = new RencimientoMapperImpl();
    }
}
