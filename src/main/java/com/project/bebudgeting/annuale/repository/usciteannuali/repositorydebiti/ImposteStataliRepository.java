package com.project.bebudgeting.annuale.repository.usciteannuali.repositorydebiti;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteStataliEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImposteStataliRepository extends CrudRepository<ImposteStataliEntity, Integer> {

}
