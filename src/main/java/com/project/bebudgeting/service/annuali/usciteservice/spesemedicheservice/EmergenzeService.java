package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.EmergenzeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EmergenzeService {
    @Autowired
    EmergenzeRepository repository;

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
    public void delete(EmergenzeEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<EmergenzeEntity> entities) {
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
     * @return Iterable<EmergenzeEntity>
     */
    // FIND
    public Iterable<EmergenzeEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<EmergenzeEntity>
     */
    public Iterable<EmergenzeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<EmergenzeEntity>
     */
    public Optional<EmergenzeEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return EmergenzeEntity
     */
    // SAVE
    public EmergenzeEntity save(EmergenzeEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<EmergenzeEntity>
     */
    public Iterable<EmergenzeEntity> saveAll(Iterable<EmergenzeEntity> entities) {
        return repository.saveAll(entities);
    }
}
