package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.ParrucchiereEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParrucchiereRepository extends CrudRepository<ParrucchiereEntity, Integer> {

}
