package com.project.bebudgeting.mensile.repository.previsti.uscite;

import com.project.bebudgeting.mensile.entity.previsti.uscite.SpesePersonaliPrevistiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpesePersonaliPrevisteRepository extends CrudRepository<SpesePersonaliPrevistiEntity, Integer> {

}
