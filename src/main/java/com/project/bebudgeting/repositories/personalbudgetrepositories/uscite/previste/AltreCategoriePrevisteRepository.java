package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.previste.AltreCategorieUscitePrevisteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategoriePrevisteRepository extends CrudRepository<AltreCategorieUscitePrevisteEntity, Integer> {

    @Override
    List<AltreCategorieUscitePrevisteEntity> findAll();
}
