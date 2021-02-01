package com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.RisparmiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RisparmiRepository extends CrudRepository<RisparmiEntity, Integer> {
    @Override
    List<RisparmiEntity> findAll();
}
