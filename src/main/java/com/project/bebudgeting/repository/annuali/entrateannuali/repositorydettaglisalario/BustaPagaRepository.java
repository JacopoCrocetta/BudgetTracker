package com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BustaPagaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BustaPagaRepository extends CrudRepository<BustaPagaEntity, Integer> {

}
