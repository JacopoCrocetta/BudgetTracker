package com.project.bebudgeting.annuale.repository;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrateAnnualiRepository extends CrudRepository<EntrateAnnualiEntity, Integer> {

}
