package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.ImposteLocaliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ImposteLocaliService {
    @Autowired
    ImposteLocaliRepository repository;

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
    public void delete(ImposteLocaliEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<ImposteLocaliEntity> entities) {
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
     * @return Iterable<ImposteLocaliEntity>
     */
    // FIND
    public Iterable<ImposteLocaliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ImposteLocaliEntity>
     */
    public Iterable<ImposteLocaliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ImposteLocaliEntity>
     */
    public Optional<ImposteLocaliEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ImposteLocaliEntity
     */
    // SAVE
    public ImposteLocaliEntity save(ImposteLocaliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ImposteLocaliEntity>
     */
    public Iterable<ImposteLocaliEntity> saveAll(Iterable<ImposteLocaliEntity> entities) {
        return repository.saveAll(entities);
    }
}