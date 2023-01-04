package com.alodiga.promotion.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationsMapperTest {

    private OperationsMapper operationsMapper;

    @BeforeEach
    public void setUp() {
        operationsMapper = new OperationsMapperImpl();
    }
}
