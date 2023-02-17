package com.alodiga.integretion.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.alodiga.integretion.domain.Rencimiento} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RencimientoDTO implements Serializable {

    private Long id;

    private Integer cedulaBeneficiario;

    @NotNull(message = "must not be null")
    @Size(max = 14)
    private String telefonoEmisor;

    @NotNull(message = "must not be null")
    @Size(max = 30)
    private String fechaHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCedulaBeneficiario() {
        return cedulaBeneficiario;
    }

    public void setCedulaBeneficiario(Integer cedulaBeneficiario) {
        this.cedulaBeneficiario = cedulaBeneficiario;
    }

    public String getTelefonoEmisor() {
        return telefonoEmisor;
    }

    public void setTelefonoEmisor(String telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RencimientoDTO)) {
            return false;
        }

        RencimientoDTO rencimientoDTO = (RencimientoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, rencimientoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RencimientoDTO{" +
            "id=" + getId() +
            ", cedulaBeneficiario=" + getCedulaBeneficiario() +
            ", telefonoEmisor='" + getTelefonoEmisor() + "'" +
            ", fechaHora='" + getFechaHora() + "'" +
            "}";
    }
}
