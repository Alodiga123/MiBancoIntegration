package com.zacco.mi.banco.util;
public class Util {
    public static String InstantDateFormatedDate(String fecha) {
        System.out.println(fecha);
        String year = fecha.split("-")[0];
        String month = fecha.split("-")[1];
        String day = fecha.split("-")[2].split("T")[0];
        String hours = fecha.split("T")[1].split(":")[0];
        String minute = fecha.split("T")[1].split(":")[1];
        String second = "00";
        StringBuilder builder = new StringBuilder();
        builder.append(year);
        builder.append("-");
        builder.append(month);
        builder.append("-");
        builder.append(day);
        builder.append(" ");
        builder.append(hours);
        builder.append(":");
        builder.append(minute);
        builder.append(":");
        builder.append(second);
        return builder.toString();
    }
    
    public static Boolean type_Document_Valid(String type_document) {
        boolean valid = false;
        String[] arreglo = Constants.TYPE_DOCUMENT_NATIONALITY;
        for (String pivote : arreglo) {
            if (pivote.equals((type_document).toUpperCase())) {
                valid = true;
                break;
            } 
        }
        return valid;
    }

    public static String first_Chars(String numberDocument) {
        int n = 1;        
        if (numberDocument == null) {
            return null;
        }

        return numberDocument.length() < n ? numberDocument : numberDocument.substring(0, n);
    }

    public static String remove_first_Char(String numberDocument) {
        if (numberDocument == null || numberDocument.length() == 0) {
            return numberDocument;
        }
        return numberDocument.substring(1);
    }
    
    public static String removerZeroPhone(String numberPhone) {
        if (numberPhone == null || numberPhone.length() == 0) {
            return numberPhone;
        }
        return numberPhone.substring(2);
    }
}
