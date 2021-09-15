package com.ksknt.wcf.pur.phoneusage.util;

import org.springframework.util.ResourceUtils;

public class Utils {

    public static final String PHONES_FILE_PATH = ResourceUtils.CLASSPATH_URL_PREFIX  + "reports/CellPhone.csv";
    public static final String PHONES_USAGE_FILE_PATH = ResourceUtils.CLASSPATH_URL_PREFIX  + "reports/CellPhoneUsageByMonth.csv";

    public static final String MAIN_REPORT_FILE_PATH = ResourceUtils.CLASSPATH_URL_PREFIX  + "reports/MainReport.jrxml";
    public static final String SUB_REPORT_FILE_PATH = ResourceUtils.CLASSPATH_URL_PREFIX  + "reports/SubReport.jrxml";

    public static final String PARAM_SUB_REPORT = "subReportParameter";
    public static final String REPORT_FILE_NAME ="inline;filename=phoneUsage.pdf";
}
