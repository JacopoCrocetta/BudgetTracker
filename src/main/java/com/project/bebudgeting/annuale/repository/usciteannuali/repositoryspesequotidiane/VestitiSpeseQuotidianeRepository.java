package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VestitiSpeseQuotidianeRepository extends CrudRepository<VestitiSpeseQuotidianeEntity, Integer> {

}
