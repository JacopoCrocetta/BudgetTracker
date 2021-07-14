package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.BolletteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteRepository extends CrudRepository<BolletteEntity, Integer> {

}
