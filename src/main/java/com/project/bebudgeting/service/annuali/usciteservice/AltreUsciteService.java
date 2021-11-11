package com.project.bebudgeting.service.annuali.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.AltreUsciteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.AltreUsciteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreUsciteService {
    @Autowired
    AltreUsciteRepository repository;

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
    public void delete(AltreUsciteEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AltreUsciteEntity> entitiesToDelete) {
        repository.deleteAll(entitiesToDelete);
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
     * @return Iterable<AltreUsciteEntity>
     */
    // FIND
    public Iterable<AltreUsciteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltreUsciteEntity>
     */
    public Iterable<AltreUsciteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltreUsciteEntity>
     */
    public Optional<AltreUsciteEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entityToSave
     * @return AltreUsciteEntity
     */
    // SAVE
    public AltreUsciteEntity save(AltreUsciteEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AltreUsciteEntity>
     */
    public Iterable<AltreUsciteEntity> saveAll(Iterable<AltreUsciteEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
