package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.ImposteStataliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImposteStataliService {
    @Autowired
    ImposteStataliRepository repository;

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
    public void delete(ImposteStataliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ImposteStataliEntity> entities) {
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
     * @return Iterable<ImposteStataliEntity>
     */
    public Iterable<ImposteStataliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ImposteStataliEntity>
     */
    public Iterable<ImposteStataliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ImposteStataliEntity>
     */
    public Optional<ImposteStataliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ImposteStataliEntity
     */
    public ImposteStataliEntity save(ImposteStataliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ImposteStataliEntity>
     */
    public Iterable<ImposteStataliEntity> saveAll(Iterable<ImposteStataliEntity> entities) {
        return repository.saveAll(entities);
    }
}
