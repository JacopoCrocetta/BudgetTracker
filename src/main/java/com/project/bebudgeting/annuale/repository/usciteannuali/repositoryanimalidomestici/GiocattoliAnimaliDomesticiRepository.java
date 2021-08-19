package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiocattoliAnimaliDomesticiRepository
        extends CrudRepository<GiocattoliAnimaliDomesticiEntity, Integer> {

}
