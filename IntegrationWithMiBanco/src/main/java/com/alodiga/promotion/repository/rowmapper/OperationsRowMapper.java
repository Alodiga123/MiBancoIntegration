package com.alodiga.promotion.repository.rowmapper;

import com.alodiga.promotion.domain.Operations;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Operations}, with proper type conversions.
 */
@Service
public class OperationsRowMapper implements BiFunction<Row, String, Operations> {

    private final ColumnConverter converter;

    public OperationsRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Operations} stored in the database.
     */
    @Override
    public Operations apply(Row row, String prefix) {
        Operations entity = new Operations();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setCedulaBeneficiario(converter.fromRow(row, prefix + "_cedula_beneficiario", String.class));
        entity.setTelefonoEmisor(converter.fromRow(row, prefix + "_telefono_emisor", String.class));
        entity.setTelefonoBeneficiario(converter.fromRow(row, prefix + "_telefono_beneficiario", String.class));
        entity.setMonto(converter.fromRow(row, prefix + "_monto", String.class));
        entity.setBancoEmisor(converter.fromRow(row, prefix + "_banco_emisor", String.class));
        entity.setConcepto(converter.fromRow(row, prefix + "_concepto", String.class));
        entity.setReferencia(converter.fromRow(row, prefix + "_referencia", String.class));
        entity.setFechaHora(converter.fromRow(row, prefix + "_fecha_hora", String.class));
        return entity;
    }
}
