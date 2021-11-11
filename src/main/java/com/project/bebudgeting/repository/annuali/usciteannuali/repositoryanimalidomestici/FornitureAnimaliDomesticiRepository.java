package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornitureAnimaliDomesticiRepository extends CrudRepository<FornitureAnimaliDomesticiEntity, Integer> {

}
