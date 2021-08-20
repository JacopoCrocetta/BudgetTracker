package com.project.bebudgeting.mensile.repository.previsti.uscite;

import com.project.bebudgeting.mensile.entity.previsti.uscite.SpeseMedichePrevistiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseMedichePrevisteRepository extends CrudRepository<SpeseMedichePrevistiEntity, Integer> {

}
