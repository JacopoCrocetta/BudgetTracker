package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.AnimaliDomesticiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimaliDomesticiRepository extends CrudRepository<AnimaliDomesticiEntity, Integer> {

    @Override
    List<AnimaliDomesticiEntity> findAll();
}
