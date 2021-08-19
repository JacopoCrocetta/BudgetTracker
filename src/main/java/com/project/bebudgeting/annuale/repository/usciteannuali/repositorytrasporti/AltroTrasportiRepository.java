package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.AltroTrasportiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroTrasportiRepository extends CrudRepository<AltroTrasportiEntity, Integer> {

}
