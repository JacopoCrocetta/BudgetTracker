package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.AltroTecnologiaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroTecnologiaRepository extends CrudRepository<AltroTecnologiaEntity, Integer> {

}
