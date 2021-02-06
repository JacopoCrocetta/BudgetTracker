package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.AlimentiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentiRepository extends CrudRepository<AlimentiEntity, Integer> {

    @Override
    List<AlimentiEntity> findAll();
}
