package com.ksknt.wcf.pur.phoneusage.service;

import com.ksknt.wcf.pur.phoneusage.model.Phone;
import com.ksknt.wcf.pur.phoneusage.model.PhoneUsage;
import com.ksknt.wcf.pur.phoneusage.repository.PhoneRepository;
import com.ksknt.wcf.pur.phoneusage.util.Utils;
import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhoneService {

    Logger logger = LoggerFactory.getLogger(PhoneService.class);

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/getPhoneInfo")
    private List<Phone> getPhoneInfo () throws FileNotFoundException {
        logger.info("API /getPhoneInfo");
        return phoneRepository.getPhones();
    }

    @GetMapping("/getPhoneUsage")
    private List<PhoneUsage> getPhoneUsage () throws FileNotFoundException {
        logger.info("API /getPhoneUsage");
        return phoneRepository.getPhonesUsage();
    }

    @GetMapping("/getData")
    private Map<Long, List<PhoneUsage>> getData () throws FileNotFoundException {
        logger.info("API /getData");
        return getPhoneUsageData();
    }


    @GetMapping("/getDataById/{id}")
    private List<PhoneUsage> getDataById (@PathVariable Long id) throws FileNotFoundException {
        logger.info("API /getDataById -- ID: " + id);
        return getPhoneUsageData().get(id);
    }

    @GetMapping(value = "/pdfReport")
    public ResponseEntity<byte[]> dataUsageReport() throws IOException, JRException {
        logger.info("API /dataUsageReport");
        File mainReportFile = ResourceUtils.getFile(Utils.MAIN_REPORT_FILE_PATH);
        File subReportFile = ResourceUtils.getFile(Utils.SUB_REPORT_FILE_PATH);

        JasperReport mainReport = JasperCompileManager.compileReport(mainReportFile.getAbsolutePath());
        JasperReport subReport = JasperCompileManager.compileReport(subReportFile.getAbsolutePath());

        Map parameters = new HashMap();
        parameters.put(Utils.PARAM_SUB_REPORT, subReport);

        JasperPrint mainReportPrint = JasperFillManager.fillReport(mainReport, parameters);

        byte[] data = JasperExportManager.exportReportToPdf(mainReportPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, Utils.REPORT_FILE_NAME);
        return ResponseEntity.ok().headers(headers).contentType(MediaType.valueOf(MediaType.APPLICATION_PDF_VALUE)).body(data);
    }

    private Map<Long, List<PhoneUsage>> getPhoneUsageData() throws FileNotFoundException {
        Map<Long, List<PhoneUsage>> data = new HashMap<>();
        List<Phone> phones = phoneRepository.getPhones();

        List<PhoneUsage> phoneUsage = phoneRepository.getPhonesUsage();

        for (Phone phone : phones) {
            List<PhoneUsage> newList = new ArrayList<>();
            data.put(phone.getEmployeeId(), newList);
        }

        for (PhoneUsage usage : phoneUsage) {
            if (data.containsKey(usage.getEmployeeId())) {
                data.get(usage.getEmployeeId()).add(usage);
            } else {
                String error = "EmployeeID not found: " + usage.getEmployeeId();
                logger.error(error);
            }
        }
        return data;
    }
}
