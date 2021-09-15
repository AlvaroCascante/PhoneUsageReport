package com.ksknt.wcf.pur.phoneusage.repository;

import com.ksknt.wcf.pur.phoneusage.model.Phone;
import com.ksknt.wcf.pur.phoneusage.model.PhoneUsage;
import com.ksknt.wcf.pur.phoneusage.util.Utils;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Repository
public class PhoneRepository {
    public List<Phone> getPhones () throws FileNotFoundException {
        File file = ResourceUtils.getFile(Utils.PHONES_FILE_PATH);

        return new CsvToBeanBuilder(new FileReader(file))
                .withType(Phone.class)
                .build()
                .parse();
    }

    public List<PhoneUsage> getPhonesUsage () throws FileNotFoundException {
        File file = ResourceUtils.getFile(Utils.PHONES_USAGE_FILE_PATH);

        return new CsvToBeanBuilder(new FileReader(file))
                .withType(PhoneUsage.class)
                .build()
                .parse();
    }
}
