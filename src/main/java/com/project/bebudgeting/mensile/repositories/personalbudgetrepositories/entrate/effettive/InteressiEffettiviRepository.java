package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.InteressiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteressiEffettiviRepository extends CrudRepository<InteressiEffettiviEntity, Integer> {
    @Override
    List<InteressiEffettiviEntity> findAll();
}
