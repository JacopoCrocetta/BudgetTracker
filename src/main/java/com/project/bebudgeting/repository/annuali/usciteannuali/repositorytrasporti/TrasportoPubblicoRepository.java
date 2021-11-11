package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.TrasportoPubblicoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasportoPubblicoRepository extends CrudRepository<TrasportoPubblicoEntity, Integer> {

}
