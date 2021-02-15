package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.AltreCategorieEntrateEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategorieEffettiveRepository extends CrudRepository<AltreCategorieEntrateEffettiviEntity, Integer> {
    @Override
    List<AltreCategorieEntrateEffettiviEntity> findAll();
}
