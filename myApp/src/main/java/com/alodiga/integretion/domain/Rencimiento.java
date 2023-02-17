package com.alodiga.integretion.domain;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Rencimiento.
 */
@Table("rencimiento")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Rencimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("cedula_beneficiario")
    private Integer cedulaBeneficiario;

    @NotNull(message = "must not be null")
    @Size(max = 14)
    @Column("telefono_emisor")
    private String telefonoEmisor;

    @NotNull(message = "must not be null")
    @Size(max = 30)
    @Column("fecha_hora")
    private String fechaHora;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Rencimiento id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCedulaBeneficiario() {
        return this.cedulaBeneficiario;
    }

    public Rencimiento cedulaBeneficiario(Integer cedulaBeneficiario) {
        this.setCedulaBeneficiario(cedulaBeneficiario);
        return this;
    }

    public void setCedulaBeneficiario(Integer cedulaBeneficiario) {
        this.cedulaBeneficiario = cedulaBeneficiario;
    }

    public String getTelefonoEmisor() {
        return this.telefonoEmisor;
    }

    public Rencimiento telefonoEmisor(String telefonoEmisor) {
        this.setTelefonoEmisor(telefonoEmisor);
        return this;
    }

    public void setTelefonoEmisor(String telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }

    public String getFechaHora() {
        return this.fechaHora;
    }

    public Rencimiento fechaHora(String fechaHora) {
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
        if (!(o instanceof Rencimiento)) {
            return false;
        }
        return id != null && id.equals(((Rencimiento) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Rencimiento{" +
            "id=" + getId() +
            ", cedulaBeneficiario=" + getCedulaBeneficiario() +
            ", telefonoEmisor='" + getTelefonoEmisor() + "'" +
            ", fechaHora='" + getFechaHora() + "'" +
            "}";
    }
}
