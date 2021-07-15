package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssicurazioneSaluteRepository extends CrudRepository<AssicurazioneSaluteEntity, Integer> {

}
