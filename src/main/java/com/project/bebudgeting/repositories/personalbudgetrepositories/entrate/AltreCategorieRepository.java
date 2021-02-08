package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.AltreCategorieEntrateEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategorieRepository extends CrudRepository<AltreCategorieEntrateEffettiveEntity, Integer> {
    @Override
    List<AltreCategorieEntrateEffettiveEntity> findAll();
}
