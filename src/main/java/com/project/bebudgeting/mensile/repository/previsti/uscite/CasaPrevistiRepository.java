package com.project.bebudgeting.mensile.repository.previsti.uscite;

import com.project.bebudgeting.mensile.entity.previsti.uscite.CasaPrevisteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaPrevistiRepository extends CrudRepository<CasaPrevisteEntity, Integer> {

}
