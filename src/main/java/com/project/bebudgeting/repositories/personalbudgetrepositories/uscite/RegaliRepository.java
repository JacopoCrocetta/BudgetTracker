package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.RegaliEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegaliRepository extends CrudRepository<RegaliEntity, Integer> {

    @Override
    List<RegaliEntity> findAll();
}
