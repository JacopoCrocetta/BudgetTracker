package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryregali;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.AltroRegaliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroRegaliRepository extends CrudRepository<AltroRegaliEntity, Integer> {

}
