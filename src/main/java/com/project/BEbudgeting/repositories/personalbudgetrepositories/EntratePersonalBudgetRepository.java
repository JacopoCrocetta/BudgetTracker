package com.project.BEbudgeting.repositories.personalbudgetrepositories;

import com.project.BEbudgeting.entities.personalbudgetingentity.EntratePersonalBudgetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntratePersonalBudgetRepository extends CrudRepository<EntratePersonalBudgetEntity, Integer> {
}
