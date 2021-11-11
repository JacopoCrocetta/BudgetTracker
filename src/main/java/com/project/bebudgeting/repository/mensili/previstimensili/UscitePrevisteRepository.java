package com.project.bebudgeting.repository.mensili.previstimensili;

import com.project.bebudgeting.entity.mensili.previsti.UscitePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UscitePrevisteRepository extends CrudRepository<UscitePrevisteEntity, Integer> {

}
