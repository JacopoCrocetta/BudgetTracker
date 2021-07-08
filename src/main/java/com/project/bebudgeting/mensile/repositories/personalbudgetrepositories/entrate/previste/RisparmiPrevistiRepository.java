package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.previste;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.previste.RisparmiPrevistiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RisparmiPrevistiRepository extends CrudRepository<RisparmiPrevistiEntity, Integer> {
    @Override
    List<RisparmiPrevistiEntity> findAll();
}
