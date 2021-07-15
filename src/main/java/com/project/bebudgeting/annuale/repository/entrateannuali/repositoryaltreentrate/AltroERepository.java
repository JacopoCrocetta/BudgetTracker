package com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroERepository extends CrudRepository<AltroEntity, Integer> {

}
