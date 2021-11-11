package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.FarmaciEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciRepository extends CrudRepository<FarmaciEntity, Integer> {

}
