package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.DebitiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitiRepository extends CrudRepository<DebitiEntity, Integer> {

}
