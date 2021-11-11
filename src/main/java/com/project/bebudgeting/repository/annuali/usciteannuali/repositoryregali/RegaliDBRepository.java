package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.RegaliDBEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegaliDBRepository extends CrudRepository<RegaliDBEntity, Integer> {

}
