package com.project.bebudgeting.service.banca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bebudgeting.repository.banca.ImportDataFromBankRepository;

@Service
public class ImportDataFromBankService {
    @Autowired
    ImportDataFromBankRepository repository;
}
