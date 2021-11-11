package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AbbonamentiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbbonamentiRepository extends CrudRepository<AbbonamentiEntity, Integer> {

}
