package com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.RisparmiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisparmiRepository extends CrudRepository<RisparmiEntity, Integer> {
}
