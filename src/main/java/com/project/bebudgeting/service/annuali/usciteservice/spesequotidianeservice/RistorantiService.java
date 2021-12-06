package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.RistorantiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.RistorantiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RistorantiService {
    @Autowired
    RistorantiRepository repository;

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
    public void delete(RistorantiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<RistorantiEntity> entities) {
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
     * @return Iterable<RistorantiEntity>
     */
    public Iterable<RistorantiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RistorantiEntity>
     */
    public Iterable<RistorantiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RistorantiEntity>
     */
    public Optional<RistorantiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return RistorantiEntity
     */
    public RistorantiEntity save(RistorantiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RistorantiEntity>
     */
    public Iterable<RistorantiEntity> saveAll(Iterable<RistorantiEntity> entities) {
        return repository.saveAll(entities);
    }
}
