package com.project.BEbudgeting.repositories.personalbudgetrepositories;

import com.project.BEbudgeting.entities.personalbudgetingentity.EntrateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrateRepository extends CrudRepository<EntrateEntity, Integer> {

    @Override
    List<EntrateEntity> findAll();
}
