package com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.previste;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.InteressiPrevistiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteressiPrevistiRepository extends CrudRepository<InteressiPrevistiEntity, Integer> {
    @Override
    List<InteressiPrevistiEntity> findAll();
}
