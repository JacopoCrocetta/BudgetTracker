package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.AbbonamentiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbbonamentiRepository extends CrudRepository<AbbonamentiEntity, Integer> {

}
