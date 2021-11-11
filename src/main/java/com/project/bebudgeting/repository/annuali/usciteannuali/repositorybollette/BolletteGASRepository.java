package com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteGASEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteGASRepository extends CrudRepository<BolletteGASEntity, Integer> {

}
