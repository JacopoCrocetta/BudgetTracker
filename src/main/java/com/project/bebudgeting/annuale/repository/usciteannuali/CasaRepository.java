package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.CasaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends CrudRepository<CasaEntity, Integer> {

}
