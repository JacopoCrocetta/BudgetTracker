package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.RiparazioniEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiparazioniRepository extends CrudRepository<RiparazioniEntity, Integer> {

}
