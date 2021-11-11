package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.GiocattoliAnimaliDomesticiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(GiocattoliAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<GiocattoliAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(giocattoliEntity -> {
            try {
                this.delete(giocattoliEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<GiocattoliAnimaliDomesticiEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return GiocattoliAnimaliDomesticiEntity
     */
    // SAVE
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
