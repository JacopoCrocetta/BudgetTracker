package com.project.bebudgeting.service.mensili.effettivi.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.AltreEntrateEffettiveEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.entrate.AltreEntrateEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreEntrateEffettiveService {
    @Autowired
    AltreEntrateEffettiveRepository repository;

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
    public void delete(AltreEntrateEffettiveEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltreEntrateEffettiveEntity> entities) {
        repository.deleteAll(entities);
    }

    /**
     * @param ids
     */
    public void deleteAllByID(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<AltreEntrateEffettiveEntity>
     */
    // FIND
    public Iterable<AltreEntrateEffettiveEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltreEntrateEffettiveEntity>
     */
    public Iterable<AltreEntrateEffettiveEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltreEntrateEffettiveEntity>
     */
    public Optional<AltreEntrateEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltreEntrateEffettiveEntity
     */
    // SAVE
    public AltreEntrateEffettiveEntity save(AltreEntrateEffettiveEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltreEntrateEffettiveEntity>
     */
    public Iterable<AltreEntrateEffettiveEntity> saveAll(Iterable<AltreEntrateEffettiveEntity> entities) {
        return repository.saveAll(entities);
    }
}
