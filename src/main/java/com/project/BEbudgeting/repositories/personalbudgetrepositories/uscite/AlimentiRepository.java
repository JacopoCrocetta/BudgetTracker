package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.AlimentiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentiRepository extends CrudRepository<AlimentiEntity, Integer> {

    @Override
    List<AlimentiEntity> findAll();
}
