package com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AltroEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroRepository extends CrudRepository<AltroEntity, Integer> {

}