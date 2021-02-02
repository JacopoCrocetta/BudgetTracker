package com.project.BEbudgeting.repositories.personalbudgetrepositories.uscite;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.InvestimentiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestimentiRepository extends CrudRepository<InvestimentiEntity, Integer> {

    @Override
    List<InvestimentiEntity> findAll();
}
