package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.PrestitoAutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestitoAutoService {
    @Autowired
    PrestitoAutoRepository repository;

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
    public void delete(PrestitoAutoEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<PrestitoAutoEntity> entities) {
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
     * @return Iterable<PrestitoAutoEntity>
     */
    public Iterable<PrestitoAutoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<PrestitoAutoEntity>
     */
    public Iterable<PrestitoAutoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<PrestitoAutoEntity>
     */
    public Optional<PrestitoAutoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return PrestitoAutoEntity
     */
    public PrestitoAutoEntity save(PrestitoAutoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<PrestitoAutoEntity>
     */
    public Iterable<PrestitoAutoEntity> saveAll(Iterable<PrestitoAutoEntity> entities) {
        return repository.saveAll(entities);
    }
}
