package com.project.bebudgeting.repository.mensili.effettivimensili.entrate;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.BustaPagaEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BustaPagaEffettiviRepository extends CrudRepository<BustaPagaEffettiveEntity, Integer> {

}
