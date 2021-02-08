package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.CasaEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasaRepository extends CrudRepository<CasaEffettiveEntity, Integer> {

    @Override
    List<CasaEffettiveEntity> findAll();
}
