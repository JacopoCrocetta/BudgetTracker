package com.project.bebudgeting.annuale.repository.entrateannuali.servicealtreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroRepository extends CrudRepository<AltroEntity, Integer> {

}
