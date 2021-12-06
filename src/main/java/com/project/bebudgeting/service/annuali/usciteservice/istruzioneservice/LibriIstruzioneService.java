package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LibriIstruzioneEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.LibriIstruzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibriIstruzioneService {
    @Autowired
    LibriIstruzioneRepository repository;

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
    public void delete(LibriIstruzioneEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<LibriIstruzioneEntity> entities) {
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
     * @return Iterable<LibriIstruzioneEntity>
     */
    public Iterable<LibriIstruzioneEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LibriIstruzioneEntity>
     */
    public Iterable<LibriIstruzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LibriIstruzioneEntity>
     */
    public Optional<LibriIstruzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return LibriIstruzioneEntity
     */
    public LibriIstruzioneEntity save(LibriIstruzioneEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LibriIstruzioneEntity>
     */
    public Iterable<LibriIstruzioneEntity> saveAll(Iterable<LibriIstruzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
