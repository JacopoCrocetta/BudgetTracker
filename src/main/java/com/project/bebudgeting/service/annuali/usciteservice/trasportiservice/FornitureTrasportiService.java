package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.FornitureTrasportiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.FornitureTrasportiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornitureTrasportiService {
    @Autowired
    FornitureTrasportiRepository repository;

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
    public void delete(FornitureTrasportiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<FornitureTrasportiEntity> entities) {
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
     * @return Iterable<FornitureTrasportiEntity>
     */
    public Iterable<FornitureTrasportiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FornitureTrasportiEntity>
     */
    public Iterable<FornitureTrasportiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FornitureTrasportiEntity>
     */
    public Optional<FornitureTrasportiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return FornitureTrasportiEntity
     */
    public FornitureTrasportiEntity save(FornitureTrasportiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FornitureTrasportiEntity>
     */
    public Iterable<FornitureTrasportiEntity> saveAll(Iterable<FornitureTrasportiEntity> entities) {
        return repository.saveAll(entities);
    }
}
