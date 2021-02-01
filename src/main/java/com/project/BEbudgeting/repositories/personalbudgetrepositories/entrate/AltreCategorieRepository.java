package com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.AltreCategorieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategorieRepository extends CrudRepository<AltreCategorieEntity, Integer> {
    @Override
    List<AltreCategorieEntity> findAll();
}
