package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HostingEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostingRepository extends CrudRepository<HostingEntity, Integer> {

}
