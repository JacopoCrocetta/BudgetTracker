package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.VestitiFigliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VestitiFigliRepository extends CrudRepository<VestitiFigliEntity, Integer> {

}
