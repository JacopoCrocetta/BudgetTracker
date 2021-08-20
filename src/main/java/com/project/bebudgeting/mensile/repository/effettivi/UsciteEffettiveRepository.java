package com.project.bebudgeting.mensile.repository.effettivi;

import com.project.bebudgeting.mensile.entity.effettivi.UsciteEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsciteEffettiveRepository extends CrudRepository<UsciteEffettiveEntity, Integer> {

}
