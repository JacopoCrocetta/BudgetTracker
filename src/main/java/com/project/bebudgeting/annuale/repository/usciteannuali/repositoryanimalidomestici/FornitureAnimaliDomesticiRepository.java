package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornitureAnimaliDomesticiRepository extends CrudRepository<FornitureAnimaliDomesticiEntity, Integer> {

}