package com.ksknt.wcf.pur.phoneusage.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Phone {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @CsvBindByName(column = "employeeId")
    private Long employeeId;

    @CsvBindByName(column = "employeeName")
    private String employeeName;

    @CsvBindByName(column = "purchaseDate")
    @CsvDate("yyyyMMdd")
    private LocalDate purchaseDate;

    @CsvBindByName(column = "model")
    private String model;

    private Integer purchaseDay;

    private Integer purchaseMonth;

    private Integer purchaseYear;

    public String getPurchaseDate() {
        return purchaseDate.format(formatter);
    }

    public void setPurchaseDate(LocalDate purchaseDateParam) {
        this.purchaseDate = purchaseDateParam;
        this.purchaseDay = purchaseDate.getDayOfMonth();
        this.purchaseMonth = purchaseDate.getMonthValue();
        this.purchaseYear = purchaseDate.getYear();
    }
}
