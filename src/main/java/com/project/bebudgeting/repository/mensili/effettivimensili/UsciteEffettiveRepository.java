package com.project.bebudgeting.repository.mensili.effettivimensili;

import com.project.bebudgeting.entity.mensili.effettivi.UsciteEffettiveEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsciteEffettiveRepository extends CrudRepository<UsciteEffettiveEntity, Integer> {

}
