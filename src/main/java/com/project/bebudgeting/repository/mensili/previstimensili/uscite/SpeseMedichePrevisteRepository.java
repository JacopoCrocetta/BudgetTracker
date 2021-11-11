package com.project.bebudgeting.repository.mensili.previstimensili.uscite;

import com.project.bebudgeting.entity.mensili.previsti.uscite.SpeseMedichePrevistiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseMedichePrevisteRepository extends CrudRepository<SpeseMedichePrevistiEntity, Integer> {

}
