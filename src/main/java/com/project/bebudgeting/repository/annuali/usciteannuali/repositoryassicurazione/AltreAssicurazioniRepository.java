package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreAssicurazioniRepository extends CrudRepository<AltreAssicurazioniEntity, Integer> {

}
