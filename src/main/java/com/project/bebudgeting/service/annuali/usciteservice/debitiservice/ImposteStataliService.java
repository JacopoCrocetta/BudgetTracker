package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.ImposteStataliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ImposteStataliService {
    @Autowired
    ImposteStataliRepository repository;

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
    public void delete(ImposteStataliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ImposteStataliEntity> entities) {
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
            throw new NotFoundException("Item not Found");
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
     * @return Iterable<ImposteStataliEntity>
     */
    // FIND
    public Iterable<ImposteStataliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ImposteStataliEntity>
     */
    public Iterable<ImposteStataliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ImposteStataliEntity>
     */
    public Optional<ImposteStataliEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ImposteStataliEntity
     */
    // SAVE
    public ImposteStataliEntity save(ImposteStataliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ImposteStataliEntity>
     */
    public Iterable<ImposteStataliEntity> saveAll(Iterable<ImposteStataliEntity> entities) {
        return repository.saveAll(entities);
    }
}
