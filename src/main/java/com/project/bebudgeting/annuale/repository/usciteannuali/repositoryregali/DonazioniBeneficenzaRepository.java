package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryregali;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.DonazioniBeneficenzaEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonazioniBeneficenzaRepository extends CrudRepository<DonazioniBeneficenzaEntity, Integer> {

}
