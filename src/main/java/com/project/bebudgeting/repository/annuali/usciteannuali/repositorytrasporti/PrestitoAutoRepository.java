package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.PrestitoAutoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestitoAutoRepository extends CrudRepository<PrestitoAutoEntity, Integer> {

}
