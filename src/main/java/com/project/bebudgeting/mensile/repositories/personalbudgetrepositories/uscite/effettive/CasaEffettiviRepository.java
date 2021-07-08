package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.CasaEffettiveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasaEffettiviRepository extends CrudRepository<CasaEffettiveEntity, Integer> {

    @Override
    List<CasaEffettiveEntity> findAll();
}
