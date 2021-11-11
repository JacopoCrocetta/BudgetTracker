package com.project.bebudgeting.repository.mensili.effettivimensili.uscite;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.BolletteEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteEffettiveRepository extends CrudRepository<BolletteEffettiviEntity, Integer> {

}
