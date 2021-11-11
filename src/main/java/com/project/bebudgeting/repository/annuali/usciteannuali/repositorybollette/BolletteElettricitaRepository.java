package com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteElettricitaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteElettricitaRepository extends CrudRepository<BolletteElettricitaEntity, Integer> {

}
