package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssicurazioneAutoRepository extends CrudRepository<AssicurazioneAutoEntity, Integer> {

}
