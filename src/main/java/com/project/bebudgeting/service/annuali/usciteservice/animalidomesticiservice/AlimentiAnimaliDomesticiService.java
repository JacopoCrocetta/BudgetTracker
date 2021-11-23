package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.AlimentiAnimaliDomesticiRepository;

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
