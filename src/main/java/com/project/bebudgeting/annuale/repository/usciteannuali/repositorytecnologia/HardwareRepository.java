package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.HardwareEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends CrudRepository<HardwareEntity, Integer> {

}
