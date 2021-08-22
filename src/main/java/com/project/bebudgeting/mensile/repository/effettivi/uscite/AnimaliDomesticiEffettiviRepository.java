package com.project.bebudgeting.mensile.repository.effettivi.uscite;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.AnimaliDomesticiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaliDomesticiEffettiviRepository extends CrudRepository<AnimaliDomesticiEffettiviEntity, Integer> {

}
