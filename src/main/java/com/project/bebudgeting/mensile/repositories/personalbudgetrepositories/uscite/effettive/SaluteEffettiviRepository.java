package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.SaluteEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaluteEffettiviRepository extends CrudRepository<SaluteEffettiveEntity, Integer> {

    @Override
    List<SaluteEffettiveEntity> findAll();
}
