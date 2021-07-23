package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.TrasportoPubblicoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasportoPubblicoRepository extends CrudRepository<TrasportoPubblicoEntity, Integer> {

}
