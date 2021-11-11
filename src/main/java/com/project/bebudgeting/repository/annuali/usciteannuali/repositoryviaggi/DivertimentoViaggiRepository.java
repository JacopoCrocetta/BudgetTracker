package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.DivertimentoViaggiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivertimentoViaggiRepository extends CrudRepository<DivertimentoViaggiEntity, Integer> {

}
