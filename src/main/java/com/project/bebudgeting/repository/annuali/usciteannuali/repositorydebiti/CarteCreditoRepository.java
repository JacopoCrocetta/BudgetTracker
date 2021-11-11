package com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.CarteCreditoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteCreditoRepository extends CrudRepository<CarteCreditoEntity, Integer> {

}
