package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.BolletteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolletteRepository extends CrudRepository<BolletteEntity, Integer> {

    @Override
    List<BolletteEntity> findAll();
}
