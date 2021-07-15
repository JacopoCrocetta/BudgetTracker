package com.project.bebudgeting.annuale.repository.usciteannuali.repositorycasa;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ArredamentoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArredamentoRepository extends CrudRepository<ArredamentoEntity, Integer> {

}
