package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.ImposteLocaliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // DELETE
    /**
     * @param entity
     */
    public void delete(ImposteLocaliEntity entity) {
        repository.delete(entity);

    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ImposteLocaliEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);

        });
    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            this.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<ImposteLocaliEntity>
     */
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

    // SAVE
    /**
     * @param entity
     * @return ImposteLocaliEntity
     */
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
