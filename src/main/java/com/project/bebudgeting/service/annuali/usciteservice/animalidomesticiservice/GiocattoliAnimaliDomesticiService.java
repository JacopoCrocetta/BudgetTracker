package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.GiocattoliAnimaliDomesticiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiocattoliAnimaliDomesticiService {
    @Autowired
    GiocattoliAnimaliDomesticiRepository repository;

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
    public void delete(GiocattoliAnimaliDomesticiEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<GiocattoliAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(giocattoliEntity -> {
            this.delete(giocattoliEntity);
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
     * @return Iterable<GiocattoliAnimaliDomesticiEntity>
     */
    public Iterable<GiocattoliAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<GiocattoliAnimaliDomesticiEntity>
     */
    public Iterable<GiocattoliAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<GiocattoliAnimaliDomesticiEntity>
     */
    public Optional<GiocattoliAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return GiocattoliAnimaliDomesticiEntity
     */
    public GiocattoliAnimaliDomesticiEntity save(GiocattoliAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<GiocattoliAnimaliDomesticiEntity>
     */
    public Iterable<GiocattoliAnimaliDomesticiEntity> saveAll(Iterable<GiocattoliAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
