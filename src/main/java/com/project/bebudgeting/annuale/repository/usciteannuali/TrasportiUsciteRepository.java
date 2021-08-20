package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.TrasportiUsciteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasportiUsciteRepository extends CrudRepository<TrasportiUsciteEntity, Integer> {

}
