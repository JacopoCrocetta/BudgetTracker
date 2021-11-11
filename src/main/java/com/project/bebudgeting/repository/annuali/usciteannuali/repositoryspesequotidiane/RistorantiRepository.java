package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.RistorantiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RistorantiRepository extends CrudRepository<RistorantiEntity, Integer> {

}
