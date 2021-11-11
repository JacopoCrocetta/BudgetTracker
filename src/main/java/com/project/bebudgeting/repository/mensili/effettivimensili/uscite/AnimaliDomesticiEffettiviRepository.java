package com.project.bebudgeting.repository.mensili.effettivimensili.uscite;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.AnimaliDomesticiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaliDomesticiEffettiviRepository extends CrudRepository<AnimaliDomesticiEffettiviEntity, Integer> {

}
