package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.effettive;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.RegaliEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegaliEffettiviRepository extends CrudRepository<RegaliEffettiviEntity, Integer> {

    @Override
    List<RegaliEffettiviEntity> findAll();
}
