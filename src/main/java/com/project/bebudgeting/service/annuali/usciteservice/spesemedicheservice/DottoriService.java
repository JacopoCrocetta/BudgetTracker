package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.DottoriRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DottoriService {
    @Autowired
    DottoriRepository repository;

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
    public void delete(DottoriEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<DottoriEntity> entities) {
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
     * @return Iterable<DottoriEntity>
     */
    // FIND
    public Iterable<DottoriEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<DottoriEntity>
     */
    public Iterable<DottoriEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<DottoriEntity>
     */
    public Optional<DottoriEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return DottoriEntity
     */
    // SAVE
    public DottoriEntity save(DottoriEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<DottoriEntity>
     */
    public Iterable<DottoriEntity> saveAll(Iterable<DottoriEntity> entities) {
        return repository.saveAll(entities);
    }
}
