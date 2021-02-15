package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.DebitiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitiEffettiviRepository extends CrudRepository<DebitiEffettiviEntity, Integer> {

    @Override
    List<DebitiEffettiviEntity> findAll();
}
