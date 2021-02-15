package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.SaluteEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalutePrevistiRepository extends CrudRepository<SaluteEffettiveEntity, Integer> {

    @Override
    List<SaluteEffettiveEntity> findAll();
}
