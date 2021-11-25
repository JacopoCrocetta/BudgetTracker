package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteAcquaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteAcquaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolletteAcquaService {
    @Autowired
    BolletteAcquaRepository repository;

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
    public void delete(BolletteAcquaEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteAcquaEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    public void deleteAll() {
        repository.deleteAll();
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
     * @return Iterable<BolletteAcquaEntity>
     */
    public Iterable<BolletteAcquaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteAcquaEntity>
     */
    public Iterable<BolletteAcquaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteAcquaEntity>
     */
    public Optional<BolletteAcquaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return BolletteAcquaEntity
     */
    public BolletteAcquaEntity save(BolletteAcquaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteAcquaEntity>
     */
    public Iterable<BolletteAcquaEntity> saveAll(Iterable<BolletteAcquaEntity> entities) {
        return repository.saveAll(entities);
    }
}
