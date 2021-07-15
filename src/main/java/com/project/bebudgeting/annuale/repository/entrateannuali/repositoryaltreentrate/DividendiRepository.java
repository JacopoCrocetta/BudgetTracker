package com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.DividendiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendiRepository extends CrudRepository<DividendiEntity, Integer> {

}
