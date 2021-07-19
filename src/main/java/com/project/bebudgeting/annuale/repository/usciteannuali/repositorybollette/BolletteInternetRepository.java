package com.project.bebudgeting.annuale.repository.usciteannuali.repositorybollette;

import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteInternetEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteInternetRepository extends CrudRepository<BolletteInternetEntity, Integer> {

}