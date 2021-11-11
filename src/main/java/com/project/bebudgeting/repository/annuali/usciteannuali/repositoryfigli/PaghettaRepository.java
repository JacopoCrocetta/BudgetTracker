package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.PaghettaFigliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaghettaRepository extends CrudRepository<PaghettaFigliEntity, Integer> {

}
