package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.MiglioramentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class MiglioramentiService {
    @Autowired
    MiglioramentiRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entity
     * @throws NotFoundException
     */
    public void delete(MiglioramentiEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<MiglioramentiEntity> entities) {
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
     * @return Iterable<MiglioramentiEntity>
     */
    public Iterable<MiglioramentiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<MiglioramentiEntity>
     */
    public Iterable<MiglioramentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<MiglioramentiEntity>
     */
    public Optional<MiglioramentiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return MiglioramentiEntity
     */
    public MiglioramentiEntity save(MiglioramentiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<MiglioramentiEntity>
     */
    public Iterable<MiglioramentiEntity> saveAll(Iterable<MiglioramentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
