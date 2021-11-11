package com.project.bebudgeting.repository.mensili.effettivimensili.entrate;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.AltreEntrateEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreEntrateEffettiveRepository extends CrudRepository<AltreEntrateEffettiveEntity, Integer> {

}
