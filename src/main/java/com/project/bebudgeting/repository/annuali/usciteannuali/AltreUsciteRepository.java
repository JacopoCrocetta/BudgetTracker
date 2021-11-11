package com.project.bebudgeting.repository.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.AltreUsciteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreUsciteRepository extends CrudRepository<AltreUsciteEntity, Integer> {
}
