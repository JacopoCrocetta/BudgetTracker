package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.AltreCategorieUsciteEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategorieEffettiveRepository extends CrudRepository<AltreCategorieUsciteEffettiveEntity, Integer> {

    @Override
    List<AltreCategorieUsciteEffettiveEntity> findAll();
}
