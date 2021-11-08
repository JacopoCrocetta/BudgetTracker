package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AsiloFigliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsiloRepository extends CrudRepository<AsiloFigliEntity, Integer> {

}
