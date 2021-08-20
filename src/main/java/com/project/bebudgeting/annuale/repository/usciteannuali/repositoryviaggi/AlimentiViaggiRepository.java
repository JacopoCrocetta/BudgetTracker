package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AlimentiViaggiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentiViaggiRepository extends CrudRepository<AlimentiViaggiEntity, Integer> {

}