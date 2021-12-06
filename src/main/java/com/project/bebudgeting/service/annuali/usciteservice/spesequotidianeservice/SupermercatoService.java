package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.SupermercatoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.SupermercatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupermercatoService {
    @Autowired
    SupermercatoRepository repository;

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
    public void delete(SupermercatoEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SupermercatoEntity> entities) {
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
     * @return Iterable<SupermercatoEntity>
     */
    public Iterable<SupermercatoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SupermercatoEntity>
     */
    public Iterable<SupermercatoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SupermercatoEntity>
     */
    public Optional<SupermercatoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return SupermercatoEntity
     */
    public SupermercatoEntity save(SupermercatoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SupermercatoEntity>
     */
    public Iterable<SupermercatoEntity> saveAll(Iterable<SupermercatoEntity> entities) {
        return repository.saveAll(entities);
    }
}
