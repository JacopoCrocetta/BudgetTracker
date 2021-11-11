package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VestitiSpeseQuotidianeRepository extends CrudRepository<VestitiSpeseQuotidianeEntity, Integer> {

}
