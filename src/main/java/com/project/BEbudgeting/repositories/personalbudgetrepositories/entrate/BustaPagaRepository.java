package com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.BustaPagaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BustaPagaRepository extends CrudRepository<BustaPagaEntity, Integer> {
    @Override
    List<BustaPagaEntity> findAll();
}
