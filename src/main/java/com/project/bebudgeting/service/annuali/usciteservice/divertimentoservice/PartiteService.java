package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.PartiteRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartiteService {
    @Autowired
    PartiteRepository repository;

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
    public void delete(PartiteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<PartiteEntity> entities) {
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
     * @return Iterable<PartiteEntity>
     */
    // FIND
    public Iterable<PartiteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<PartiteEntity>
     */
    public Iterable<PartiteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<PartiteEntity>
     */
    public Optional<PartiteEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return PartiteEntity
     */
    // SAVE
    public PartiteEntity save(PartiteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<PartiteEntity>
     */
    public Iterable<PartiteEntity> saveAll(Iterable<PartiteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
