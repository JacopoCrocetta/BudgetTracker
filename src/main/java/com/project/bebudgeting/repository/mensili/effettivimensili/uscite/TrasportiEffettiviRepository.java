package com.project.bebudgeting.repository.mensili.effettivimensili.uscite;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.TrasportiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasportiEffettiviRepository extends CrudRepository<TrasportiEffettiviEntity, Integer> {

}
