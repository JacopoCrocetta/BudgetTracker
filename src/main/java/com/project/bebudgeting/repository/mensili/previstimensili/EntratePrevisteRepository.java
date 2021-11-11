package com.project.bebudgeting.repository.mensili.previstimensili;

import com.project.bebudgeting.entity.mensili.previsti.EntratePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntratePrevisteRepository extends CrudRepository<EntratePrevisteEntity, Integer> {

}
