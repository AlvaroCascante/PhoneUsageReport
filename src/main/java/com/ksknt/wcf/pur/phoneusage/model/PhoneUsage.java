package com.ksknt.wcf.pur.phoneusage.model;

import com.ksknt.wcf.pur.phoneusage.util.DateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PhoneUsage {
    @CsvBindByName(column = "emplyeeId")
    private Long employeeId;

    @CsvCustomBindByName(column = "date", converter = DateConverter.class)
    private LocalDate usageDate;

    @CsvBindByName(column = "totalMinutes")
    private String totalMinutes;

    @CsvBindByName(column = "totalData")
    private String totalData;

    private Integer usageDay;

    private Integer usageMonth;

    private Integer usageYear;

    public void setUsageDate(LocalDate usageDateParam) {
        this.usageDate = usageDateParam;
        this.usageDay = usageDate.getDayOfMonth();
        this.usageMonth = usageDate.getMonthValue();
        this.usageYear = usageDate.getYear();
    }
}
