package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.AnimaliDomesticiEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimaliDomesticiEffettiviRepository extends CrudRepository<AnimaliDomesticiEffettiveEntity, Integer> {

    @Override
    List<AnimaliDomesticiEffettiveEntity> findAll();
}
