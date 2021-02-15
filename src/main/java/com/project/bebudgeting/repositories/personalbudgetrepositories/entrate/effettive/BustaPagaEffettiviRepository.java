package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.BustaPagaEffettiveEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BustaPagaEffettiviRepository extends CrudRepository<BustaPagaEffettiveEntity, Integer> {
    @Override
    List<BustaPagaEffettiveEntity> findAll();
}
