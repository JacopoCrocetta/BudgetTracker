package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteGASEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteGASRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteGASService {
    @Autowired
    BolletteGASRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(BolletteGASEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteGASEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
     * @return Iterable<BolletteGASEntity>
     */
    // FIND
    public Iterable<BolletteGASEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteGASEntity>
     */
    public Iterable<BolletteGASEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteGASEntity>
     */
    public Optional<BolletteGASEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BolletteGASEntity
     */
    // SAVE
    public BolletteGASEntity save(BolletteGASEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteGASEntity>
     */
    public Iterable<BolletteGASEntity> saveAll(Iterable<BolletteGASEntity> entities) {
        return repository.saveAll(entities);
    }
}
