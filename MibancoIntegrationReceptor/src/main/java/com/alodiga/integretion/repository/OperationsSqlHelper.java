package com.alodiga.integretion.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class OperationsSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("cedula_beneficiario", table, columnPrefix + "_cedula_beneficiario"));
        columns.add(Column.aliased("telefono_emisor", table, columnPrefix + "_telefono_emisor"));
        columns.add(Column.aliased("telefono_beneficiario", table, columnPrefix + "_telefono_beneficiario"));
        columns.add(Column.aliased("monto", table, columnPrefix + "_monto"));
        columns.add(Column.aliased("banco_emisor", table, columnPrefix + "_banco_emisor"));
        columns.add(Column.aliased("concepto", table, columnPrefix + "_concepto"));
        columns.add(Column.aliased("referencia", table, columnPrefix + "_referencia"));
        columns.add(Column.aliased("fecha_hora", table, columnPrefix + "_fecha_hora"));

        return columns;
    }
}
