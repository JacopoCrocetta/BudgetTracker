package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryregali;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.RegaliDBEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegaliDBRepository extends CrudRepository<RegaliDBEntity, Integer> {

}
