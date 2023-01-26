package com.zacco.mi.banco.integration.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Operations.
 */
@Entity
@Table(name = "operations")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 16)
    @Column(name = "cedula_beneficiario", length = 16)
    private String cedulaBeneficiario;

    @Size(max = 14)
    @Column(name = "telefono_emisor", length = 14)
    private String telefonoEmisor;

    @Size(max = 14)
    @Column(name = "telefono_beneficiario", length = 14)
    private String telefonoBeneficiario;

    @Size(max = 20)
    @Column(name = "monto", length = 20)
    private String monto;

    @Size(max = 4)
    @Column(name = "banco_emisor", length = 4)
    private String bancoEmisor;

    @Size(max = 255)
    @Column(name = "concepto", length = 255)
    private String concepto;

    @Size(max = 15)
    @Column(name = "referencia", length = 15)
    private String referencia;

    @Size(max = 30)
    @Column(name = "fecha_hora", length = 30)
    private String fechaHora;

    @Column(name = "status")
    private Boolean status;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

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

    public Boolean getStatus() {
        return this.status;
    }

    public Operations status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public Operations description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
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
            ", status='" + getStatus() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

    public Operations(String cedulaBeneficiario, String telefonoEmisor, String telefonoBeneficiario, String monto, String bancoEmisor, String concepto, String referencia, String fechaHora, Boolean status, String description) {
        this.cedulaBeneficiario = cedulaBeneficiario;
        this.telefonoEmisor = telefonoEmisor;
        this.telefonoBeneficiario = telefonoBeneficiario;
        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.concepto = concepto;
        this.referencia = referencia;
        this.fechaHora = fechaHora;
        this.status = status;
        this.description = description;
    }
    
    public Operations(){}
}
