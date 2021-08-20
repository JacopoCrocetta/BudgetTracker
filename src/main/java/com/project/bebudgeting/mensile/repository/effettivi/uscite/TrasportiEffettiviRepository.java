package com.project.bebudgeting.mensile.repository.effettivi.uscite;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.TrasportiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasportiEffettiviRepository extends CrudRepository<TrasportiEffettiviEntity, Integer> {

}
