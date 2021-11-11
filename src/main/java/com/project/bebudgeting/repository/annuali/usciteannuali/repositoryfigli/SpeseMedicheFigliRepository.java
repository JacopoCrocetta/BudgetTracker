package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.SpeseMedicheFigliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseMedicheFigliRepository extends CrudRepository<SpeseMedicheFigliEntity, Integer> {

}
