package com.project.bebudgeting.repository.mensili.previstimensili.entrate;

import com.project.bebudgeting.entity.mensili.previsti.entrate.AltreEntratePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreEntratePrevisteRepository extends CrudRepository<AltreEntratePrevisteEntity, Integer> {

}
