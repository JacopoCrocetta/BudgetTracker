package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.effettive;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.InteressiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteressiEffettiviRepository extends CrudRepository<InteressiEffettiviEntity, Integer> {
    @Override
    List<InteressiEffettiviEntity> findAll();
}
