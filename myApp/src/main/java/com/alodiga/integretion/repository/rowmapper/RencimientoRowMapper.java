package com.alodiga.integretion.repository.rowmapper;

import com.alodiga.integretion.domain.Rencimiento;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Rencimiento}, with proper type conversions.
 */
@Service
public class RencimientoRowMapper implements BiFunction<Row, String, Rencimiento> {

    private final ColumnConverter converter;

    public RencimientoRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Rencimiento} stored in the database.
     */
    @Override
    public Rencimiento apply(Row row, String prefix) {
        Rencimiento entity = new Rencimiento();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setCedulaBeneficiario(converter.fromRow(row, prefix + "_cedula_beneficiario", Integer.class));
        entity.setTelefonoEmisor(converter.fromRow(row, prefix + "_telefono_emisor", String.class));
        entity.setFechaHora(converter.fromRow(row, prefix + "_fecha_hora", String.class));
        return entity;
    }
}
