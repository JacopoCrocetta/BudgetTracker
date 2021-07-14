package com.project.bebudgeting.annuale.repository.entrateannuali;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltreEntrateRepository extends CrudRepository<AltreEntrateEntity, Integer> {
}
