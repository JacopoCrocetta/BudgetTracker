package com.project.bebudgeting.repository.mensili.effettivimensili.uscite;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.ViaggiEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggiEffettiviRepository extends CrudRepository<ViaggiEffettiviEntity, Integer> {

}
