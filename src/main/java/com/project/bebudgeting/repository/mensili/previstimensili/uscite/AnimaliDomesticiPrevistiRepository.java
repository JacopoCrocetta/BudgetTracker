package com.project.bebudgeting.repository.mensili.previstimensili.uscite;

import com.project.bebudgeting.entity.mensili.previsti.uscite.AnimaliDomesticiPrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaliDomesticiPrevistiRepository extends CrudRepository<AnimaliDomesticiPrevisteEntity, Integer> {

}
