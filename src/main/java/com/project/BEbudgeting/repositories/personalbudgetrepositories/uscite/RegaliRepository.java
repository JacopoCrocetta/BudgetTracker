package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.RegaliEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegaliRepository extends CrudRepository<RegaliEntity, Integer> {

    @Override
    List<RegaliEntity> findAll();
}
