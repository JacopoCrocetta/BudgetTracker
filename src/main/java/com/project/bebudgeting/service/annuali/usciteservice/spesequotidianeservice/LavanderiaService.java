package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.LavanderiaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.LavanderiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LavanderiaService {
    @Autowired
    LavanderiaRepository repository;

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
    public void delete(LavanderiaEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<LavanderiaEntity> entities) {
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
     * @return Iterable<LavanderiaEntity>
     */
    public Iterable<LavanderiaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LavanderiaEntity>
     */
    public Iterable<LavanderiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LavanderiaEntity>
     */
    public Optional<LavanderiaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return LavanderiaEntity
     */
    public LavanderiaEntity save(LavanderiaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LavanderiaEntity>
     */
    public Iterable<LavanderiaEntity> saveAll(Iterable<LavanderiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
