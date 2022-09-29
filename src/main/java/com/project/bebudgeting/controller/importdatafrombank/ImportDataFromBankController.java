package com.project.bebudgeting.controller.importdatafrombank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bebudgeting.service.banca.ImportDataFromBankService;

import io.swagger.annotations.Api;

@Api(value = "Import Data From File", tags = "Import Data From File", description = "REST APIs related to ImportDataFromFileController")
@RestController
@RequestMapping("/importdatafrombank")
public class ImportDataFromBankController {

    @Autowired
    ImportDataFromBankService importDataFromBankService;
    
}
