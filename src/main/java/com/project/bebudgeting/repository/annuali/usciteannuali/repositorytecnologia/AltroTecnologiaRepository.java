package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.AltroTecnologiaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroTecnologiaRepository extends CrudRepository<AltroTecnologiaEntity, Integer> {

}
