package com.alodiga.integretion.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.alodiga.integretion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RencimientoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Rencimiento.class);
        Rencimiento rencimiento1 = new Rencimiento();
        rencimiento1.setId(1L);
        Rencimiento rencimiento2 = new Rencimiento();
        rencimiento2.setId(rencimiento1.getId());
        assertThat(rencimiento1).isEqualTo(rencimiento2);
        rencimiento2.setId(2L);
        assertThat(rencimiento1).isNotEqualTo(rencimiento2);
        rencimiento1.setId(null);
        assertThat(rencimiento1).isNotEqualTo(rencimiento2);
    }
}
