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
}
