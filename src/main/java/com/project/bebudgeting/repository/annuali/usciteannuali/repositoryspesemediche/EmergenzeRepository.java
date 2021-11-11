package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.EmergenzeEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergenzeRepository extends CrudRepository<EmergenzeEntity, Integer> {

}
