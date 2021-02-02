package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.AnimaliDomesticiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimaliDomesticiRepository extends CrudRepository<AnimaliDomesticiEntity, Integer> {

    @Override
    List<AnimaliDomesticiEntity> findAll();
}
