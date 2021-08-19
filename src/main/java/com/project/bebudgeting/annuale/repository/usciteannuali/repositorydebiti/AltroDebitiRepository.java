package com.project.bebudgeting.annuale.repository.usciteannuali.repositorydebiti;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltroDebitiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroDebitiRepository extends CrudRepository<AltroDebitiEntity, Integer> {

}
