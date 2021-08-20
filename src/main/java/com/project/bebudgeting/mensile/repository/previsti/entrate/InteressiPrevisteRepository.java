package com.project.bebudgeting.mensile.repository.previsti.entrate;

import com.project.bebudgeting.mensile.entity.previsti.entrate.InteressiPrevistiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteressiPrevisteRepository extends CrudRepository<InteressiPrevistiEntity, Integer> {

}
