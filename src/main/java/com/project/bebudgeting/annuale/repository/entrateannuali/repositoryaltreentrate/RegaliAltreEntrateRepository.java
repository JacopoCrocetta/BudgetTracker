package com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegaliAltreEntrateRepository extends CrudRepository<RegaliAltreEntrateEntity, Integer> {
}
