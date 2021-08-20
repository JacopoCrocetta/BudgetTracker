package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.VestitiFigliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VestitiFigliRepository extends CrudRepository<VestitiFigliEntity, Integer> {

}
