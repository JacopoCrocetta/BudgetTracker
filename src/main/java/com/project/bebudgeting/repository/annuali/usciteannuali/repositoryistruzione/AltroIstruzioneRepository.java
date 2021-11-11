package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.AltroIstruzioneEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroIstruzioneRepository extends CrudRepository<AltroIstruzioneEntity, Integer> {

}
