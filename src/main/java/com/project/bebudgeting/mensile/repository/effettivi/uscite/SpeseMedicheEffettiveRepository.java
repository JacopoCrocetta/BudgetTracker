package com.project.bebudgeting.mensile.repository.effettivi.uscite;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.SpeseMedicheEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseMedicheEffettiveRepository extends CrudRepository<SpeseMedicheEffettiviEntity, Integer> {

}
