package com.project.bebudgeting.annuale.repository;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsciteAnnualiRepository extends CrudRepository<UsciteAnnualiEntity, Integer> {

}
