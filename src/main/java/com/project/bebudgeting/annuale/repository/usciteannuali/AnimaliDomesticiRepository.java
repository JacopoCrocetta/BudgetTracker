package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaliDomesticiRepository extends CrudRepository<AnimaliDomesticiEntity, Integer> {

}
