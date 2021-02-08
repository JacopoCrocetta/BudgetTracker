package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.InvestimentiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestimentiRepository extends CrudRepository<InvestimentiEffettiviEntity, Integer> {

    @Override
    List<InvestimentiEffettiviEntity> findAll();
}
