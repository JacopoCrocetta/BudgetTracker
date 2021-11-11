package com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.MiglioramentiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiglioramentiRepository extends CrudRepository<MiglioramentiEntity, Integer> {

}
