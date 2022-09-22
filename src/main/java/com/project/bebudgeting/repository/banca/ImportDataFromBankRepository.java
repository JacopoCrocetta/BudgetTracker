package com.project.bebudgeting.repository.banca;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportDataFromBankRepository extends MongoRepository<Integer, String>{
    
}
