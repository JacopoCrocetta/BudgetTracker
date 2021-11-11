package com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TeatroEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroRepository extends CrudRepository<TeatroEntity, Integer> {

}
