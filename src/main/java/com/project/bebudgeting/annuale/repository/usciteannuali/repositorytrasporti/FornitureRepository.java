package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.FornitureEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornitureRepository extends CrudRepository<FornitureEntity, Integer> {

}
