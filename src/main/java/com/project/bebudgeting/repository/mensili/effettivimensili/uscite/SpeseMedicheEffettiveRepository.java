package com.project.bebudgeting.repository.mensili.effettivimensili.uscite;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.SpeseMedicheEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseMedicheEffettiveRepository extends CrudRepository<SpeseMedicheEffettiviEntity, Integer> {

}
