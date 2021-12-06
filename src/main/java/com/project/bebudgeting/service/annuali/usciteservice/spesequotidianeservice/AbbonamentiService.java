package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AbbonamentiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.AbbonamentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbbonamentiService {
    @Autowired
    AbbonamentiRepository repository;

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
    public void delete(AbbonamentiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AbbonamentiEntity> entities) {
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
     * @return Iterable<AbbonamentiEntity>
     */
    public Iterable<AbbonamentiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AbbonamentiEntity>
     */
    public Iterable<AbbonamentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AbbonamentiEntity>
     */
    public Optional<AbbonamentiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AbbonamentiEntity
     */
    public AbbonamentiEntity save(AbbonamentiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AbbonamentiEntity>
     */
    public Iterable<AbbonamentiEntity> saveAll(Iterable<AbbonamentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
