package com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteInternetEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteInternetRepository extends CrudRepository<BolletteInternetEntity, Integer> {

}
