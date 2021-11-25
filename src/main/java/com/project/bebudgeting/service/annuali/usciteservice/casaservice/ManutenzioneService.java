package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.ManutenzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManutenzioneService {
    @Autowired
    ManutenzioneRepository repository;

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
    public void delete(ManutenzioneEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ManutenzioneEntity> entities) {
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
     * @return Iterable<ManutenzioneEntity>
     */
    public Iterable<ManutenzioneEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ManutenzioneEntity>
     */
    public Iterable<ManutenzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ManutenzioneEntity>
     */
    public Optional<ManutenzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ManutenzioneEntity
     */
    public ManutenzioneEntity save(ManutenzioneEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ManutenzioneEntity>
     */
    public Iterable<ManutenzioneEntity> saveAll(Iterable<ManutenzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
