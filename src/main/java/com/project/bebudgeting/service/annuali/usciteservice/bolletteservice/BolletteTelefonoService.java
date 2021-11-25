package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTelefonoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteTelefonoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolletteTelefonoService {
    @Autowired
    BolletteTelefonoRepository repository;

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
    public void delete(BolletteTelefonoEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteTelefonoEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    public void deleteAll() {
        repository.deleteAll();
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
     * @return Iterable<BolletteTelefonoEntity>
     */
    public Iterable<BolletteTelefonoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteTelefonoEntity>
     */
    public Iterable<BolletteTelefonoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteTelefonoEntity>
     */
    public Optional<BolletteTelefonoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return BolletteTelefonoEntity
     */
    public BolletteTelefonoEntity save(BolletteTelefonoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteTelefonoEntity>
     */
    public Iterable<BolletteTelefonoEntity> saveAll(Iterable<BolletteTelefonoEntity> entities) {
        return repository.saveAll(entities);
    }
}
