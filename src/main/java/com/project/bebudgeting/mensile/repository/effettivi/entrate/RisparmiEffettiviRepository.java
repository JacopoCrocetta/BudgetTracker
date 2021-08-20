package com.project.bebudgeting.mensile.repository.effettivi.entrate;

import com.project.bebudgeting.mensile.entity.effettivi.entrate.RisparmiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisparmiEffettiviRepository extends CrudRepository<RisparmiEffettiviEntity, Integer> {

}
