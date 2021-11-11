package com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.CommissioniEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissioniRepository extends CrudRepository<CommissioniEntity, Integer> {

}
