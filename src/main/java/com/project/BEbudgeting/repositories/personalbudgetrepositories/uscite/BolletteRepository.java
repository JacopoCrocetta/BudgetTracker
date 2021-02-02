package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.BolletteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolletteRepository extends CrudRepository<BolletteEntity, Integer> {

    @Override
    List<BolletteEntity> findAll();
}
