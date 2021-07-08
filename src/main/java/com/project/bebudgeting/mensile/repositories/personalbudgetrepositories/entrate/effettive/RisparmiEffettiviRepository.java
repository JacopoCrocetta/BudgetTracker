package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.RisparmiEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RisparmiEffettiviRepository extends CrudRepository<RisparmiEffettiveEntity, Integer> {
    @Override
    List<RisparmiEffettiveEntity> findAll();
}
