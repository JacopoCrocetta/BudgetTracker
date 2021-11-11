package com.project.bebudgeting.repository.mensili.previstimensili.uscite;

import com.project.bebudgeting.entity.mensili.previsti.uscite.AltreUscitePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreUscitePrevisteRepository extends CrudRepository<AltreUscitePrevisteEntity, Integer> {

}
