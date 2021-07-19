package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.previste;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.DebitiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitiPrevistiRepository extends CrudRepository<DebitiEffettiviEntity, Integer> {

    @Override
    List<DebitiEffettiviEntity> findAll();
}