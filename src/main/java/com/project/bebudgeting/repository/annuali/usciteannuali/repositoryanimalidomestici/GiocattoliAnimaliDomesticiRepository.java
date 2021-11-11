package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiocattoliAnimaliDomesticiRepository
                extends CrudRepository<GiocattoliAnimaliDomesticiEntity, Integer> {

}
