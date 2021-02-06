package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.SaluteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaluteRepository extends CrudRepository<SaluteEntity, Integer> {

    @Override
    List<SaluteEntity> findAll();
}
