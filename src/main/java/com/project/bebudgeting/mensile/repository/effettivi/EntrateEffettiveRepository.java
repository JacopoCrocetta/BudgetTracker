package com.project.bebudgeting.mensile.repository.effettivi;

import com.project.bebudgeting.mensile.entity.effettivi.EntrateEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrateEffettiveRepository extends CrudRepository<EntrateEffettiveEntity, Integer> {

}
