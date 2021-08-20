package com.project.bebudgeting.mensile.repository.previsti;

import com.project.bebudgeting.mensile.entity.previsti.UscitePrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UscitePrevisteRepository extends CrudRepository<UscitePrevisteEntity, Integer> {

}
