package com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.TraslocoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraslocoRepository extends CrudRepository<TraslocoEntity, Integer> {

}
