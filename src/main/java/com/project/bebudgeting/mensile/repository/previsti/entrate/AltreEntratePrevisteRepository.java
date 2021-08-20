package com.project.bebudgeting.mensile.repository.previsti.entrate;

import com.project.bebudgeting.mensile.entity.previsti.entrate.AltreEntratePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreEntratePrevisteRepository extends CrudRepository<AltreEntratePrevisteEntity, Integer> {

}
