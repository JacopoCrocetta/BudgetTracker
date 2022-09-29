package com.project.bebudgeting.repository.banca;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.bebudgeting.entity.importdatafrombank.TransactionEntity;

@Repository
public interface ImportDataFromBankRepository extends MongoRepository<TransactionEntity, String>{
    
}
