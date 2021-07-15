package com.project.bebudgeting.annuale.repository.usciteannuali.repositorybollette;

import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteElettricitaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteElettricitaRepository extends CrudRepository<BolletteElettricitaEntity, Integer> {

}
