package com.project.bebudgeting.mensile.repository.previsti.uscite;

import com.project.bebudgeting.mensile.entity.previsti.uscite.AltreUscitePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreUscitePrevisteRepository extends CrudRepository<AltreUscitePrevisteEntity, Integer> {

}