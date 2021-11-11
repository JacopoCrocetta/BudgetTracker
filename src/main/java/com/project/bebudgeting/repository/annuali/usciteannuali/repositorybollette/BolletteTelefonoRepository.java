package com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTelefonoEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolletteTelefonoRepository extends CrudRepository<BolletteTelefonoEntity, Integer> {

}
