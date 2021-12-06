package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.CureSpecialisticheEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.CureSpecialisticheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CureSpecialisticheService {
    @Autowired
    CureSpecialisticheRepository repository;

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
    public void delete(CureSpecialisticheEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<CureSpecialisticheEntity> entities) {
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
     * @return Iterable<CureSpecialisticheEntity>
     */
    public Iterable<CureSpecialisticheEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<CureSpecialisticheEntity>
     */
    public Iterable<CureSpecialisticheEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<CureSpecialisticheEntity>
     */
    public Optional<CureSpecialisticheEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return CureSpecialisticheEntity
     */
    public CureSpecialisticheEntity save(CureSpecialisticheEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<CureSpecialisticheEntity>
     */
    public Iterable<CureSpecialisticheEntity> saveAll(Iterable<CureSpecialisticheEntity> entities) {
        return repository.saveAll(entities);
    }
}
