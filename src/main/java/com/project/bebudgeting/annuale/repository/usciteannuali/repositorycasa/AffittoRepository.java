package com.project.bebudgeting.annuale.repository.usciteannuali.repositorycasa;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AffittoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffittoRepository extends CrudRepository<AffittoEntity, Integer> {

}
