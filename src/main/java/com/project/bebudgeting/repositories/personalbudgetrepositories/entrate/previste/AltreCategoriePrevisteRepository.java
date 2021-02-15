package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.AltreCategorieEntratePrevisteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategoriePrevisteRepository extends CrudRepository<AltreCategorieEntratePrevisteEntity, Integer> {
    @Override
    List<AltreCategorieEntratePrevisteEntity> findAll();
}
