package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AbbonamentiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.AbbonamentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AbbonamentiService {
    @Autowired
    AbbonamentiRepository repository;

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
    public void delete(AbbonamentiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AbbonamentiEntity> entities) {
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
     * @return Iterable<AbbonamentiEntity>
     */
    // FIND
    public Iterable<AbbonamentiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AbbonamentiEntity>
     */
    public Iterable<AbbonamentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AbbonamentiEntity>
     */
    public Optional<AbbonamentiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AbbonamentiEntity
     */
    // SAVE
    public AbbonamentiEntity save(AbbonamentiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AbbonamentiEntity>
     */
    public Iterable<AbbonamentiEntity> saveAll(Iterable<AbbonamentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
