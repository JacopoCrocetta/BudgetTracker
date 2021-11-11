package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.AltroRegaliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroRegaliRepository extends CrudRepository<AltroRegaliEntity, Integer> {

}
