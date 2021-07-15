package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.HostingEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostingRepository extends CrudRepository<HostingEntity, Integer> {

}
