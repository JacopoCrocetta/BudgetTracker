package com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.uscite.previste;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.InvestimentiEffettiviEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestimentiPrevistiRepository extends CrudRepository<InvestimentiEffettiviEntity, Integer> {

    @Override
    List<InvestimentiEffettiviEntity> findAll();
}
