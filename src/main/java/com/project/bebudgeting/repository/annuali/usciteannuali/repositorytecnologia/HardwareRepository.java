package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HardwareEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends CrudRepository<HardwareEntity, Integer> {

}
