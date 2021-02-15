package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.AlimentiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentiEffettiviRepository extends CrudRepository<AlimentiEffettiviEntity, Integer> {

    @Override
    List<AlimentiEffettiviEntity> findAll();
}
