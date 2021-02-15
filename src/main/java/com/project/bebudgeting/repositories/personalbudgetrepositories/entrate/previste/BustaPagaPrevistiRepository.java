package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.BustaPagaPrevisteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BustaPagaPrevistiRepository extends CrudRepository<BustaPagaPrevisteEntity, Integer> {
    @Override
    List<BustaPagaPrevisteEntity> findAll();
}
