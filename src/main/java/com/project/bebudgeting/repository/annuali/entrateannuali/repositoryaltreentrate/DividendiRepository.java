package com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.DividendiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendiRepository extends CrudRepository<DividendiEntity, Integer> {

}
