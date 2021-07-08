package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.previste;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.AlimentiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentiPrevistiRepository extends CrudRepository<AlimentiEffettiviEntity, Integer> {

    @Override
    List<AlimentiEffettiviEntity> findAll();
}
