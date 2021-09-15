package com.ksknt.wcf.pur.phoneusage.service;

import com.ksknt.wcf.pur.phoneusage.model.Phone;
import com.ksknt.wcf.pur.phoneusage.model.PhoneUsage;
import com.ksknt.wcf.pur.phoneusage.repository.PhoneRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
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
                System.out.println("EmployeeID not found: " + usage.getEmployeeId());
            }
        }
        return data;
    }
}
