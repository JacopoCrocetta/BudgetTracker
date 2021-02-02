package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.SaluteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaluteRepository extends CrudRepository<SaluteEntity, Integer> {

    @Override
    List<SaluteEntity> findAll();
}
