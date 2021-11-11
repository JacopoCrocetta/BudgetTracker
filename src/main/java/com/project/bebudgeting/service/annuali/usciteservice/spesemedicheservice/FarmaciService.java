package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.FarmaciEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.FarmaciRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FarmaciService {
    @Autowired
    FarmaciRepository repository;

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
     * @throws NotFoundException
     */
    public void delete(FarmaciEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<FarmaciEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
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
        } else {
            throw new NotFoundException("Item not found");
        }
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
     * @return Iterable<FarmaciEntity>
     */
    // FIND
    public Iterable<FarmaciEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FarmaciEntity>
     */
    public Iterable<FarmaciEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FarmaciEntity>
     */
    public Optional<FarmaciEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return FarmaciEntity
     */
    // SAVE
    public FarmaciEntity save(FarmaciEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FarmaciEntity>
     */
    public Iterable<FarmaciEntity> saveAll(Iterable<FarmaciEntity> entities) {
        return repository.saveAll(entities);
    }
}
