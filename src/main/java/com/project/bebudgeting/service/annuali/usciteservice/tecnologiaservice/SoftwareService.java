package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.SoftwareEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.SoftwareRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareService {
    @Autowired
    SoftwareRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entity
     */
    public void delete(SoftwareEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SoftwareEntity> entities) {
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
     * @return Iterable<SoftwareEntity>
     */
    public Iterable<SoftwareEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SoftwareEntity>
     */
    public Iterable<SoftwareEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SoftwareEntity>
     */
    public Optional<SoftwareEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return SoftwareEntity
     */
    public SoftwareEntity save(SoftwareEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SoftwareEntity>
     */
    public Iterable<SoftwareEntity> saveAll(Iterable<SoftwareEntity> entities) {
        return repository.saveAll(entities);
    }
}
