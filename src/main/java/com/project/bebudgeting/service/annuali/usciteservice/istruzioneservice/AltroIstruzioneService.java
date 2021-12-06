package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.AltroIstruzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroIstruzioneService {
    @Autowired
    AltroIstruzioneRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entity
     */
    public void delete(AltroIstruzioneEntity entity) {
        repository.delete(entity);

    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroIstruzioneEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);

        });
    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            this.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<AltroIstruzioneEntity>
     */
    public Iterable<AltroIstruzioneEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroIstruzioneEntity>
     */
    public Iterable<AltroIstruzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroIstruzioneEntity>
     */
    public Optional<AltroIstruzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroIstruzioneEntity
     */
    public AltroIstruzioneEntity save(AltroIstruzioneEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroIstruzioneEntity>
     */
    public Iterable<AltroIstruzioneEntity> saveAll(Iterable<AltroIstruzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
