package com.project.bebudgeting.mensile.repository.previsti.entrate;

import com.project.bebudgeting.mensile.entity.previsti.entrate.BustaPagaPrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BustaPagaPrevisteRepository extends CrudRepository<BustaPagaPrevisteEntity, Integer> {

}
