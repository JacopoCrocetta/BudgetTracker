package com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.MusicaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends CrudRepository<MusicaEntity, Integer> {

}
