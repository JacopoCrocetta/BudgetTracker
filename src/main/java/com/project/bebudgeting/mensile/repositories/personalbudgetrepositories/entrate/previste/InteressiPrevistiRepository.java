package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.previste;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.previste.InteressiPrevistiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteressiPrevistiRepository extends CrudRepository<InteressiPrevistiEntity, Integer> {
    @Override
    List<InteressiPrevistiEntity> findAll();
}
