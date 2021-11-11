package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AltroViaggiEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroViaggiRepository extends CrudRepository<AltroViaggiEntity, Integer> {

}
