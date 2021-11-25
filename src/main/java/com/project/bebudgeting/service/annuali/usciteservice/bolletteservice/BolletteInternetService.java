package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteInternetEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteInternetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolletteInternetService {
    @Autowired
    BolletteInternetRepository repository;

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
    public void delete(BolletteInternetEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteInternetEntity> entities) {
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
     * @return Iterable<BolletteInternetEntity>
     */
    public Iterable<BolletteInternetEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteInternetEntity>
     */
    public Iterable<BolletteInternetEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteInternetEntity>
     */
    public Optional<BolletteInternetEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return BolletteInternetEntity
     */
    public BolletteInternetEntity save(BolletteInternetEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteInternetEntity>
     */
    public Iterable<BolletteInternetEntity> saveAll(Iterable<BolletteInternetEntity> entities) {
        return repository.saveAll(entities);
    }
}
