package com.alodiga.integretion.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Operations.
 */
@Table("operations")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Size(max = 16)
    @Column("cedula_beneficiario")
    private String cedulaBeneficiario;

    @Size(max = 14)
    @Column("telefono_emisor")
    private String telefonoEmisor;

    @Size(max = 14)
    @Column("telefono_beneficiario")
    private String telefonoBeneficiario;

    @Size(max = 20)
    @Column("monto")
    private String monto;

    @Size(max = 4)
    @Column("banco_emisor")
    private String bancoEmisor;

    @Size(max = 255)
    @Column("concepto")
    private String concepto;

    @Size(max = 15)
    @Column("referencia")
    private String referencia;

    @Size(max = 30)
    @Column("fecha_hora")
    private String fechaHora;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Operations id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedulaBeneficiario() {
        return this.cedulaBeneficiario;
    }

    public Operations cedulaBeneficiario(String cedulaBeneficiario) {
        this.setCedulaBeneficiario(cedulaBeneficiario);
        return this;
    }

    public void setCedulaBeneficiario(String cedulaBeneficiario) {
        this.cedulaBeneficiario = cedulaBeneficiario;
    }

    public String getTelefonoEmisor() {
        return this.telefonoEmisor;
    }

    public Operations telefonoEmisor(String telefonoEmisor) {
        this.setTelefonoEmisor(telefonoEmisor);
        return this;
    }

    public void setTelefonoEmisor(String telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }

    public String getTelefonoBeneficiario() {
        return this.telefonoBeneficiario;
    }

    public Operations telefonoBeneficiario(String telefonoBeneficiario) {
        this.setTelefonoBeneficiario(telefonoBeneficiario);
        return this;
    }

    public void setTelefonoBeneficiario(String telefonoBeneficiario) {
        this.telefonoBeneficiario = telefonoBeneficiario;
    }

    public String getMonto() {
        return this.monto;
    }

    public Operations monto(String monto) {
        this.setMonto(monto);
        return this;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getBancoEmisor() {
        return this.bancoEmisor;
    }

    public Operations bancoEmisor(String bancoEmisor) {
        this.setBancoEmisor(bancoEmisor);
        return this;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public String getConcepto() {
        return this.concepto;
    }

    public Operations concepto(String concepto) {
        this.setConcepto(concepto);
        return this;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public Operations referencia(String referencia) {
        this.setReferencia(referencia);
        return this;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFechaHora() {
        return this.fechaHora;
    }

    public Operations fechaHora(String fechaHora) {
        this.setFechaHora(fechaHora);
        return this;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Operations)) {
            return false;
        }
        return id != null && id.equals(((Operations) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Operations{" +
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
