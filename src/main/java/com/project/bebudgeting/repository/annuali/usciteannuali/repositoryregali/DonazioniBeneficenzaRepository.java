package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.DonazioniBeneficenzaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonazioniBeneficenzaRepository extends CrudRepository<DonazioniBeneficenzaEntity, Integer> {

}
