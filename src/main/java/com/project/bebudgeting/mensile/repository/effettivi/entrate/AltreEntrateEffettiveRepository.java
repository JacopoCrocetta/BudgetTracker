package com.project.bebudgeting.mensile.repository.effettivi.entrate;

import com.project.bebudgeting.mensile.entity.effettivi.entrate.AltreEntrateEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreEntrateEffettiveRepository extends CrudRepository<AltreEntrateEffettiveEntity, Integer> {

}
