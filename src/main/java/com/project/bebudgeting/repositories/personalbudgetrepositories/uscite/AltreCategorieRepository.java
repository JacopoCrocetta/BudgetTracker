package com.project.bebudgeting.repositories.personalbudgetrepositories.uscite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltreCategorieRepository extends CrudRepository<AltreCategorieRepository, Integer> {

    @Override
    List<AltreCategorieRepository> findAll();
}
