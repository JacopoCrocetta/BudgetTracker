package com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BonusEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends CrudRepository<BonusEntity, Integer> {

}
