package com.project.bebudgeting.annuale.repository.entrateannuali.repositorydettaglisalario;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.CommissioniEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissioniRepository extends CrudRepository<CommissioniEntity, Integer> {

}
