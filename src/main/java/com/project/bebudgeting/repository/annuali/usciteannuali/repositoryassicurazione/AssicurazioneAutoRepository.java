package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssicurazioneAutoRepository extends CrudRepository<AssicurazioneAutoEntity, Integer> {

}
