package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.AlimentiAnimaliDomesticiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimentiAnimaliDomesticiService {
    @Autowired
    AlimentiAnimaliDomesticiRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entityToDelete
     */
    public void delete(AlimentiAnimaliDomesticiEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AlimentiAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(alimentiEntity -> {
            this.delete(alimentiEntity);
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

    /**
     * @return Iterable<AlimentiAnimaliDomesticiEntity>
     */
    // FIND
    public Iterable<AlimentiAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AlimentiAnimaliDomesticiEntity>
     */
    public Iterable<AlimentiAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AlimentiAnimaliDomesticiEntity>
     */
    public Optional<AlimentiAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AlimentiAnimaliDomesticiEntity
     */
    // SAVE
    public AlimentiAnimaliDomesticiEntity save(AlimentiAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AlimentiAnimaliDomesticiEntity>
     */
    public Iterable<AlimentiAnimaliDomesticiEntity> saveAll(Iterable<AlimentiAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
