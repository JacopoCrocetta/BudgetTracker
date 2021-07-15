package com.project.bebudgeting.annuale.repository.entrateannuali.repositorydettaglisalario;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BonusEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends CrudRepository<BonusEntity, Integer> {

}
