package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.FornitureAnimaliDomesticiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FornitureAnimaliDomesticiService {
    @Autowired
    FornitureAnimaliDomesticiRepository repository;

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
    public void delete(FornitureAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
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
    public void deleteAll(Iterable<FornitureAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(fornitureEntity -> {
            try {
                this.delete(fornitureEntity);
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
     * @return Iterable<FornitureAnimaliDomesticiEntity>
     */
    // FIND
    public Iterable<FornitureAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FornitureAnimaliDomesticiEntity>
     */
    public Iterable<FornitureAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FornitureAnimaliDomesticiEntity>
     */
    public Optional<FornitureAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return FornitureAnimaliDomesticiEntity
     */
    // SAVE
    public FornitureAnimaliDomesticiEntity save(FornitureAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FornitureAnimaliDomesticiEntity>
     */
    public Iterable<FornitureAnimaliDomesticiEntity> saveAll(Iterable<FornitureAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
