package com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AttivitaOutsideEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttivitaOutsideRepository extends CrudRepository<AttivitaOutsideEntity, Integer> {

}
