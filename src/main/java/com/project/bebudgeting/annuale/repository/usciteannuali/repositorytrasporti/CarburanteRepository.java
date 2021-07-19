package com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.CarburanteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarburanteRepository extends CrudRepository<CarburanteEntity, Integer> {

}