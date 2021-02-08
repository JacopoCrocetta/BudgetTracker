package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.InteressiEffettivoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteressiRepository extends CrudRepository<InteressiEffettivoEntity, Integer> {
    @Override
    List<InteressiEffettivoEntity> findAll();
}
