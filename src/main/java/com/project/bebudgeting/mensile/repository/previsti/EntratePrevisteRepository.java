package com.project.bebudgeting.mensile.repository.previsti;

import com.project.bebudgeting.mensile.entity.previsti.EntratePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntratePrevisteRepository extends CrudRepository<EntratePrevisteEntity, Integer> {

}
