package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.BolloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolloService {
    @Autowired
    BolloRepository repository;

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
    public void delete(BolloEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolloEntity> entities) {
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
     * @return Iterable<BolloEntity>
     */
    public Iterable<BolloEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolloEntity>
     */
    public Iterable<BolloEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolloEntity>
     */
    public Optional<BolloEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return BolloEntity
     */
    public BolloEntity save(BolloEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolloEntity>
     */
    public Iterable<BolloEntity> saveAll(Iterable<BolloEntity> entities) {
        return repository.saveAll(entities);
    }
}
