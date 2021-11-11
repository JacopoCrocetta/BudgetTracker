package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.ParrucchiereEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.ParrucchiereRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ParrucchiereService {
    @Autowired
    ParrucchiereRepository repository;

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
    public void delete(ParrucchiereEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ParrucchiereEntity> entities) {
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
     * @return Iterable<ParrucchiereEntity>
     */
    // FIND
    public Iterable<ParrucchiereEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ParrucchiereEntity>
     */
    public Iterable<ParrucchiereEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ParrucchiereEntity>
     */
    public Optional<ParrucchiereEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ParrucchiereEntity
     */
    // SAVE
    public ParrucchiereEntity save(ParrucchiereEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ParrucchiereEntity>
     */
    public Iterable<ParrucchiereEntity> saveAll(Iterable<ParrucchiereEntity> entities) {
        return repository.saveAll(entities);
    }
}
