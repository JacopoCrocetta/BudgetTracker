package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HardwareEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.HardwareRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardwareService {
    @Autowired
    HardwareRepository repository;

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
    public void delete(HardwareEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<HardwareEntity> entities) {
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
     * @return Iterable<HardwareEntity>
     */
    public Iterable<HardwareEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<HardwareEntity>
     */
    public Iterable<HardwareEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<HardwareEntity>
     */
    public Optional<HardwareEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return HardwareEntity
     */
    public HardwareEntity save(HardwareEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<HardwareEntity>
     */
    public Iterable<HardwareEntity> saveAll(Iterable<HardwareEntity> entities) {
        return repository.saveAll(entities);
    }
}
