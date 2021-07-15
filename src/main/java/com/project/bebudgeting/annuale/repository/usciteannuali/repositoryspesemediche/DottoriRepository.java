package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesemediche;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.DottoriEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DottoriRepository extends CrudRepository<DottoriEntity, Integer> {

}
