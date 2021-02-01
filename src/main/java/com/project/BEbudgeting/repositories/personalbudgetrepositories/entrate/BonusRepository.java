package com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.BonusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonusRepository extends CrudRepository<BonusEntity, Integer> {
    @Override
    List<BonusEntity> findAll();
}
