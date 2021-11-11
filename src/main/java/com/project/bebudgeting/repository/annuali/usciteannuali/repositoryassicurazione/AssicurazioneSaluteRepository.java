package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssicurazioneSaluteRepository extends CrudRepository<AssicurazioneSaluteEntity, Integer> {

}
