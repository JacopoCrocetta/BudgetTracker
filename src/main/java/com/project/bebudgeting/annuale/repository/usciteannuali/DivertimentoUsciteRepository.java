package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.DivertimentoUsciteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivertimentoUsciteRepository extends CrudRepository<DivertimentoUsciteEntity, Integer> {

}
