package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.BustaPagaEffettiveEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BustaPagaRepository extends CrudRepository<BustaPagaEffettiveEntity, Integer> {
    @Override
    List<BustaPagaEffettiveEntity> findAll();
}
