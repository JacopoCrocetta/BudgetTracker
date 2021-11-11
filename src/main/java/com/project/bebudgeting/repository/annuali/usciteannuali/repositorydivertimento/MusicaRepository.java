package com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.MusicaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends CrudRepository<MusicaEntity, Integer> {

}
