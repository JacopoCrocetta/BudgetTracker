package com.project.bebudgeting.service.banca;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.bebudgeting.entity.importdatafrombank.TransactionEntity;
import com.project.bebudgeting.repository.banca.ImportDataFromBankRepository;

@Service
public class ImportDataFromBankService {
    @Autowired
    ImportDataFromBankRepository repository;

    //FIND ALL
    public List<TransactionEntity> findAll(){
        return repository.findAll();
    }

    public List<TransactionEntity> findAllByEntity(Example<TransactionEntity> filter){
        return repository.findAll(filter);
    }

    public List<TransactionEntity> findAllByEntityAndSort(Example<TransactionEntity> filter, Sort sort){
        return repository.findAll(filter, sort);
    }

    //SAVE
    public List<TransactionEntity> saveDataFromBank()  {
        String command ="curl -X GET https://ob.nordigen.com/api/v2/accounts/065da497-e6af-4950-88ed-2edbc0577d20/transactions/";
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
