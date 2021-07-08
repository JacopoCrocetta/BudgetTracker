package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.BolletteEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolletteEffettiveRepository extends CrudRepository<BolletteEffettiviEntity, Integer> {

    @Override
    List<BolletteEffettiviEntity> findAll();
}
