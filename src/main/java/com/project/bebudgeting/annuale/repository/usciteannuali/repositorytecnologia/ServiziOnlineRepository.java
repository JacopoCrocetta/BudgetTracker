package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytecnologia;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.ServiziOnlineEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiziOnlineRepository extends CrudRepository<ServiziOnlineEntity, Integer> {

}
