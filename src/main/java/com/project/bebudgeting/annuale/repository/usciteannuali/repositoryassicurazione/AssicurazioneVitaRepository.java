package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssicurazioneVitaRepository extends CrudRepository<AssicurazioneVitaEntity, Integer> {

}
