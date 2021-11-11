package com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.InteressiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteressiRepository extends CrudRepository<InteressiEntity, Integer> {
}
