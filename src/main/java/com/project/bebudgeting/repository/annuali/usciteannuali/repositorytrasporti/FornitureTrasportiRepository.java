package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.FornitureTrasportiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornitureTrasportiRepository extends CrudRepository<FornitureTrasportiEntity, Integer> {

}
