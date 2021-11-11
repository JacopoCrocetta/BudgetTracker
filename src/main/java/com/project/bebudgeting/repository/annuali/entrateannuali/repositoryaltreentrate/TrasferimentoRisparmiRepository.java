package com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasferimentoRisparmiRepository extends CrudRepository<TrasferimentoRisparmiEntity, Integer> {

}
