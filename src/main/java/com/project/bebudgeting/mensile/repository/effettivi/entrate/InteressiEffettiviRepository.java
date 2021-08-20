package com.project.bebudgeting.mensile.repository.effettivi.entrate;

import com.project.bebudgeting.mensile.entity.effettivi.entrate.InteressiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteressiEffettiviRepository extends CrudRepository<InteressiEffettiviEntity, Integer> {

}
