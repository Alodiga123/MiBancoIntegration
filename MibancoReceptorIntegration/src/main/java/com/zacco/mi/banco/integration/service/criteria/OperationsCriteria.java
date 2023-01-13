package com.zacco.mi.banco.integration.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.zacco.mi.banco.integration.domain.Operations} entity. This class is used
 * in {@link com.zacco.mi.banco.integration.web.rest.OperationsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /operations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OperationsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cedulaBeneficiario;

    private StringFilter telefonoEmisor;

    private StringFilter telefonoBeneficiario;

    private StringFilter monto;

    private StringFilter bancoEmisor;

    private StringFilter concepto;

    private StringFilter referencia;

    private StringFilter fechaHora;

    private Boolean distinct;

    public OperationsCriteria() {}

    public OperationsCriteria(OperationsCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cedulaBeneficiario = other.cedulaBeneficiario == null ? null : other.cedulaBeneficiario.copy();
        this.telefonoEmisor = other.telefonoEmisor == null ? null : other.telefonoEmisor.copy();
        this.telefonoBeneficiario = other.telefonoBeneficiario == null ? null : other.telefonoBeneficiario.copy();
        this.monto = other.monto == null ? null : other.monto.copy();
        this.bancoEmisor = other.bancoEmisor == null ? null : other.bancoEmisor.copy();
        this.concepto = other.concepto == null ? null : other.concepto.copy();
        this.referencia = other.referencia == null ? null : other.referencia.copy();
        this.fechaHora = other.fechaHora == null ? null : other.fechaHora.copy();
        this.distinct = other.distinct;
    }

    @Override
    public OperationsCriteria copy() {
        return new OperationsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCedulaBeneficiario() {
        return cedulaBeneficiario;
    }

    public StringFilter cedulaBeneficiario() {
        if (cedulaBeneficiario == null) {
            cedulaBeneficiario = new StringFilter();
        }
        return cedulaBeneficiario;
    }

    public void setCedulaBeneficiario(StringFilter cedulaBeneficiario) {
        this.cedulaBeneficiario = cedulaBeneficiario;
    }

    public StringFilter getTelefonoEmisor() {
        return telefonoEmisor;
    }

    public StringFilter telefonoEmisor() {
        if (telefonoEmisor == null) {
            telefonoEmisor = new StringFilter();
        }
        return telefonoEmisor;
    }

    public void setTelefonoEmisor(StringFilter telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }

    public StringFilter getTelefonoBeneficiario() {
        return telefonoBeneficiario;
    }

    public StringFilter telefonoBeneficiario() {
        if (telefonoBeneficiario == null) {
            telefonoBeneficiario = new StringFilter();
        }
        return telefonoBeneficiario;
    }

    public void setTelefonoBeneficiario(StringFilter telefonoBeneficiario) {
        this.telefonoBeneficiario = telefonoBeneficiario;
    }

    public StringFilter getMonto() {
        return monto;
    }

    public StringFilter monto() {
        if (monto == null) {
            monto = new StringFilter();
        }
        return monto;
    }

    public void setMonto(StringFilter monto) {
        this.monto = monto;
    }

    public StringFilter getBancoEmisor() {
        return bancoEmisor;
    }

    public StringFilter bancoEmisor() {
        if (bancoEmisor == null) {
            bancoEmisor = new StringFilter();
        }
        return bancoEmisor;
    }

    public void setBancoEmisor(StringFilter bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public StringFilter getConcepto() {
        return concepto;
    }

    public StringFilter concepto() {
        if (concepto == null) {
            concepto = new StringFilter();
        }
        return concepto;
    }

    public void setConcepto(StringFilter concepto) {
        this.concepto = concepto;
    }

    public StringFilter getReferencia() {
        return referencia;
    }

    public StringFilter referencia() {
        if (referencia == null) {
            referencia = new StringFilter();
        }
        return referencia;
    }

    public void setReferencia(StringFilter referencia) {
        this.referencia = referencia;
    }

    public StringFilter getFechaHora() {
        return fechaHora;
    }

    public StringFilter fechaHora() {
        if (fechaHora == null) {
            fechaHora = new StringFilter();
        }
        return fechaHora;
    }

    public void setFechaHora(StringFilter fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final OperationsCriteria that = (OperationsCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cedulaBeneficiario, that.cedulaBeneficiario) &&
            Objects.equals(telefonoEmisor, that.telefonoEmisor) &&
            Objects.equals(telefonoBeneficiario, that.telefonoBeneficiario) &&
            Objects.equals(monto, that.monto) &&
            Objects.equals(bancoEmisor, that.bancoEmisor) &&
            Objects.equals(concepto, that.concepto) &&
            Objects.equals(referencia, that.referencia) &&
            Objects.equals(fechaHora, that.fechaHora) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            cedulaBeneficiario,
            telefonoEmisor,
            telefonoBeneficiario,
            monto,
            bancoEmisor,
            concepto,
            referencia,
            fechaHora,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OperationsCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cedulaBeneficiario != null ? "cedulaBeneficiario=" + cedulaBeneficiario + ", " : "") +
            (telefonoEmisor != null ? "telefonoEmisor=" + telefonoEmisor + ", " : "") +
            (telefonoBeneficiario != null ? "telefonoBeneficiario=" + telefonoBeneficiario + ", " : "") +
            (monto != null ? "monto=" + monto + ", " : "") +
            (bancoEmisor != null ? "bancoEmisor=" + bancoEmisor + ", " : "") +
            (concepto != null ? "concepto=" + concepto + ", " : "") +
            (referencia != null ? "referencia=" + referencia + ", " : "") +
            (fechaHora != null ? "fechaHora=" + fechaHora + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
