package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.SoftwareEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareRepository extends CrudRepository<SoftwareEntity, Integer> {

}
