package com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.LibriDivertimentoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibriDivertimentoRepository extends CrudRepository<LibriDivertimentoEntity, Integer> {

}
