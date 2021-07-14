package com.project.bebudgeting.annuale.repository.entrateannuali.servicealtreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.InteressiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteressiRepository extends CrudRepository<InteressiEntity, Integer> {
}
