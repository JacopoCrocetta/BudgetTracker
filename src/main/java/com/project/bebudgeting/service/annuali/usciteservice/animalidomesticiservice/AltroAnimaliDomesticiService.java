package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.AltroAnimaliDomesticiRepository;

@Service
public class AltroAnimaliDomesticiService {
    @Autowired
    AltroAnimaliDomesticiRepository repository;

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
    public void delete(AltroAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
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
    public void deleteAll(Iterable<AltroAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(altroEntity -> {
            try {
                this.delete(altroEntity);
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
     * @return Iterable<AltroAnimaliDomesticiEntity>
     */
    // FIND
    public Iterable<AltroAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroAnimaliDomesticiEntity>
     */
    public Iterable<AltroAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroAnimaliDomesticiEntity>
     */
    public Optional<AltroAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltroAnimaliDomesticiEntity
     */
    // SAVE
    public AltroAnimaliDomesticiEntity save(AltroAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroAnimaliDomesticiEntity>
     */
    public Iterable<AltroAnimaliDomesticiEntity> saveAll(Iterable<AltroAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
