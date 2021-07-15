package com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasferimentoRisparmiRepository extends CrudRepository<TrasferimentoRisparmiEntity, Integer> {

}
