package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.BustaPagaEffettiveEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BustaPagaEffettiviRepository extends CrudRepository<BustaPagaEffettiveEntity, Integer> {
    @Override
    List<BustaPagaEffettiveEntity> findAll();
}
