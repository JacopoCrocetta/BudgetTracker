package com.project.bebudgeting.repository.mensili.effettivimensili;

import com.project.bebudgeting.entity.mensili.effettivi.EntrateEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrateEffettiveRepository extends CrudRepository<EntrateEffettiveEntity, Integer> {

}
