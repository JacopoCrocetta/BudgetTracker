package com.project.bebudgeting.repository.mensili.effettivimensili.entrate;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.RisparmiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisparmiEffettiviRepository extends CrudRepository<RisparmiEffettiviEntity, Integer> {

}
