package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.RisparmiEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RisparmiRepository extends CrudRepository<RisparmiEffettiveEntity, Integer> {
    @Override
    List<RisparmiEffettiveEntity> findAll();
}
