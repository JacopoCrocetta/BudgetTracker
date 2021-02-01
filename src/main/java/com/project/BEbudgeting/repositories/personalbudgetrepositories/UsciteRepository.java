package com.project.BEbudgeting.repositories.personalbudgetrepositories;

import com.project.BEbudgeting.entities.personalbudgetingentity.UsciteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsciteRepository extends CrudRepository<UsciteEntity, Integer> {
    @Override
    List<UsciteEntity> findAll();
}
