package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.VestitiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VestitiRepository extends CrudRepository<VestitiEntity, Integer> {

}
