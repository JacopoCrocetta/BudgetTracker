package com.project.BEbudgeting.repositories.personalbudgetrepositories;

import com.project.BEbudgeting.entities.personalbudgetingentity.UscitePersonalBudgetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UscitePersonalBudgetRepository extends CrudRepository<UscitePersonalBudgetEntity, Integer> {
}
