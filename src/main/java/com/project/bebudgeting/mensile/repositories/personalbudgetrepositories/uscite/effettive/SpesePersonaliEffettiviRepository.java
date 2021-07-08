package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.SpesePersonaliEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpesePersonaliEffettiviRepository extends CrudRepository<SpesePersonaliEffettiveEntity, Integer> {

    @Override
    List<SpesePersonaliEffettiveEntity> findAll();
}
