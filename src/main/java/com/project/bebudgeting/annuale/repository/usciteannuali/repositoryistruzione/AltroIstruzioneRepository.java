package com.project.bebudgeting.annuale.repository.usciteannuali.repositoryistruzione;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.AltroIstruzioneEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AltroIstruzioneRepository extends CrudRepository<AltroIstruzioneEntity, Integer> {

}
