package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.SpeseMedicheEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseMedicheRepository extends CrudRepository<SpeseMedicheEntity, Integer> {

}
