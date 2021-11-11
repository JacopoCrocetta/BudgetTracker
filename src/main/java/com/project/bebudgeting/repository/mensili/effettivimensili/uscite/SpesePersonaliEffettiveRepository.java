package com.project.bebudgeting.repository.mensili.effettivimensili.uscite;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.SpesePersonaliEffettiviEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpesePersonaliEffettiveRepository extends CrudRepository<SpesePersonaliEffettiviEntity, Integer> {

}
