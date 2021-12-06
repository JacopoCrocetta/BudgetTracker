package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.ParrucchiereEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.ParrucchiereRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParrucchiereService {
    @Autowired
    ParrucchiereRepository repository;

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
    public void delete(ParrucchiereEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ParrucchiereEntity> entities) {
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
     * @return Iterable<ParrucchiereEntity>
     */
    public Iterable<ParrucchiereEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ParrucchiereEntity>
     */
    public Iterable<ParrucchiereEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ParrucchiereEntity>
     */
    public Optional<ParrucchiereEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ParrucchiereEntity
     */
    public ParrucchiereEntity save(ParrucchiereEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ParrucchiereEntity>
     */
    public Iterable<ParrucchiereEntity> saveAll(Iterable<ParrucchiereEntity> entities) {
        return repository.saveAll(entities);
    }
}
