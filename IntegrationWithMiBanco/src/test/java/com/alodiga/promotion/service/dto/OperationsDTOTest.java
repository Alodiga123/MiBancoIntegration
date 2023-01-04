package com.alodiga.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.alodiga.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OperationsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(OperationsDTO.class);
        OperationsDTO operationsDTO1 = new OperationsDTO();
        operationsDTO1.setId(1L);
        OperationsDTO operationsDTO2 = new OperationsDTO();
        assertThat(operationsDTO1).isNotEqualTo(operationsDTO2);
        operationsDTO2.setId(operationsDTO1.getId());
        assertThat(operationsDTO1).isEqualTo(operationsDTO2);
        operationsDTO2.setId(2L);
        assertThat(operationsDTO1).isNotEqualTo(operationsDTO2);
        operationsDTO1.setId(null);
        assertThat(operationsDTO1).isNotEqualTo(operationsDTO2);
    }
}
