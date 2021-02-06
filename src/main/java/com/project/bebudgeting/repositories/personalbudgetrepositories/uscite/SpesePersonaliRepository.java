package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.SpesePersonaliEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpesePersonaliRepository extends CrudRepository<SpesePersonaliEntity, Integer> {

    @Override
    List<SpesePersonaliEntity> findAll();
}
