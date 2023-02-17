package com.alodiga.integretion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.alodiga.integretion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RencimientoDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RencimientoDTO.class);
        RencimientoDTO rencimientoDTO1 = new RencimientoDTO();
        rencimientoDTO1.setId(1L);
        RencimientoDTO rencimientoDTO2 = new RencimientoDTO();
        assertThat(rencimientoDTO1).isNotEqualTo(rencimientoDTO2);
        rencimientoDTO2.setId(rencimientoDTO1.getId());
        assertThat(rencimientoDTO1).isEqualTo(rencimientoDTO2);
        rencimientoDTO2.setId(2L);
        assertThat(rencimientoDTO1).isNotEqualTo(rencimientoDTO2);
        rencimientoDTO1.setId(null);
        assertThat(rencimientoDTO1).isNotEqualTo(rencimientoDTO2);
    }
}
