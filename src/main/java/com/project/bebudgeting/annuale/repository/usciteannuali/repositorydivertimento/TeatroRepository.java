package com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TeatroEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroRepository extends CrudRepository<TeatroEntity, Integer> {

}
