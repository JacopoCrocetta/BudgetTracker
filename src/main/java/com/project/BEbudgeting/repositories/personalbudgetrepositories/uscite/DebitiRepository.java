package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.DebitiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitiRepository extends CrudRepository<DebitiEntity, Integer> {

    @Override
    List<DebitiEntity> findAll();
}
