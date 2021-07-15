package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.TrasportiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasportiRepository extends CrudRepository<TrasportiEntity, Integer> {

}
