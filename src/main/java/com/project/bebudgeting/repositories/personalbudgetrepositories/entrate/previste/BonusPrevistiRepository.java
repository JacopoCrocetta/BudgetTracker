package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.BonusPrevistiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonusPrevistiRepository extends CrudRepository<BonusPrevistiEntity, Integer> {
    @Override
    List<BonusPrevistiEntity> findAll();
}
