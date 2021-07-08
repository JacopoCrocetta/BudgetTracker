package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.BonusEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonusEffettiviRepository extends CrudRepository<BonusEffettiveEntity, Integer> {
    @Override
    List<BonusEffettiveEntity> findAll();
}
