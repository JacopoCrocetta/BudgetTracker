package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.CureSpecialisticheEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CureSpecialisticheRepository extends CrudRepository<CureSpecialisticheEntity, Integer> {

}
