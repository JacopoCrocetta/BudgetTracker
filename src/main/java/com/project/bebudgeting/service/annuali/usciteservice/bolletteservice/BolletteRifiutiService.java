package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteRifiutiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteRifiutiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolletteRifiutiService {
    @Autowired
    BolletteRifiutiRepository repository;

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
    public void delete(BolletteRifiutiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteRifiutiEntity> entities) {
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

    /**
     * @return Iterable<BolletteRifiutiEntity>
     */
    // FIND
    public Iterable<BolletteRifiutiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteRifiutiEntity>
     */
    public Iterable<BolletteRifiutiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteRifiutiEntity>
     */
    public Optional<BolletteRifiutiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BolletteRifiutiEntity
     */
    // SAVE
    public BolletteRifiutiEntity save(BolletteRifiutiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteRifiutiEntity>
     */
    public Iterable<BolletteRifiutiEntity> saveAll(Iterable<BolletteRifiutiEntity> entities) {
        return repository.saveAll(entities);
    }
}
