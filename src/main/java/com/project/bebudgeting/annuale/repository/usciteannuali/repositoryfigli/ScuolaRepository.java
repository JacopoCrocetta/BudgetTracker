package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.ScuolaFigliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScuolaRepository extends CrudRepository<ScuolaFigliEntity, Integer> {

}
