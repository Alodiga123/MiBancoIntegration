package com.alodiga.promotion.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.alodiga.promotion.domain.Operations} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OperationsDTO implements Serializable {

    private Long id;

    @Size(max = 16)
    private String cedulaBeneficiario;

    @Size(max = 14)
    private String telefonoEmisor;

    @Size(max = 14)
    private String telefonoBeneficiario;

    @Size(max = 20)
    private String monto;

    @Size(max = 4)
    private String bancoEmisor;

    @Size(max = 255)
    private String concepto;

    @Size(max = 15)
    private String referencia;

    @Size(max = 30)
    private String fechaHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedulaBeneficiario() {
        return cedulaBeneficiario;
    }

    public void setCedulaBeneficiario(String cedulaBeneficiario) {
        this.cedulaBeneficiario = cedulaBeneficiario;
    }

    public String getTelefonoEmisor() {
        return telefonoEmisor;
    }

    public void setTelefonoEmisor(String telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }

    public String getTelefonoBeneficiario() {
        return telefonoBeneficiario;
    }

    public void setTelefonoBeneficiario(String telefonoBeneficiario) {
        this.telefonoBeneficiario = telefonoBeneficiario;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
        if (!(o instanceof OperationsDTO)) {
            return false;
        }

        OperationsDTO operationsDTO = (OperationsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, operationsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OperationsDTO{" +
            "id=" + getId() +
            ", cedulaBeneficiario='" + getCedulaBeneficiario() + "'" +
            ", telefonoEmisor='" + getTelefonoEmisor() + "'" +
            ", telefonoBeneficiario='" + getTelefonoBeneficiario() + "'" +
            ", monto='" + getMonto() + "'" +
            ", bancoEmisor='" + getBancoEmisor() + "'" +
            ", concepto='" + getConcepto() + "'" +
            ", referencia='" + getReferencia() + "'" +
            ", fechaHora='" + getFechaHora() + "'" +
            "}";
    }
}
