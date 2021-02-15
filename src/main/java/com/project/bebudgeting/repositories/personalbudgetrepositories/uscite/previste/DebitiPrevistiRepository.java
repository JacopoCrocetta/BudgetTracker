package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.DebitiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitiPrevistiRepository extends CrudRepository<DebitiEffettiviEntity, Integer> {

    @Override
    List<DebitiEffettiviEntity> findAll();
}
