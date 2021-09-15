package com.ksknt.wcf.pur.phoneusage.util;

import com.opencsv.bean.AbstractBeanField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;

public class DateConverter extends AbstractBeanField {

    @Override
    protected Object convert(String date) {

        // This converter is used to format the data contained in the CSV file
        // Because Day and Month could be one or two digits and that generates an error
        // trying to convert the CSV row automatically
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.MONTH_OF_YEAR, 1, 2, SignStyle.NEVER)
                .appendLiteral("/")
                .appendValue(ChronoField.DAY_OF_MONTH, 1,2, SignStyle.NEVER)
                .appendLiteral("/")
                .appendValue(ChronoField.YEAR, 4)
                .toFormatter();
        return LocalDate.parse(date, formatter);
    }
}
