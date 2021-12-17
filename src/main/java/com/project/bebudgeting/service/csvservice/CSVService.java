package com.project.bebudgeting.service.csvservice;

import java.io.IOException;
import java.util.List;

import com.project.bebudgeting.helper.CSVHelper;
import com.project.bebudgeting.helper.CSVHelperEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
    public boolean save(MultipartFile file) {
        CSVHelper csvHelper = new CSVHelper();
        if (csvHelper.hasCSVFormat(file)) {
            return false;
        } else {
            try {
                List<CSVHelperEntity> tutorials = csvHelper.csvToTutorials(file.getInputStream());
                // repository.saveAll(tutorials);
                for (CSVHelperEntity csvHelperEntity : tutorials) {
                    System.out.println(csvHelperEntity.getCategoria());
                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException("fail to store csv data: " + e.getMessage());
            }
        }
    }
}
