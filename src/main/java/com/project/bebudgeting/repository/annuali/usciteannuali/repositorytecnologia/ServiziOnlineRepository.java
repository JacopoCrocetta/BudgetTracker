package com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.ServiziOnlineEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiziOnlineRepository extends CrudRepository<ServiziOnlineEntity, Integer> {

}
