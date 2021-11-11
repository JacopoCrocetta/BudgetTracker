package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.SupermercatoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermercatoRepository extends CrudRepository<SupermercatoEntity, Integer> {

}
