package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.AltroDebitiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroDebitiService {
    @Autowired
    AltroDebitiRepository repository;

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
    public void delete(AltroDebitiEntity entity) {
        repository.delete(entity);

    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroDebitiEntity> entities) {
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
     * @return Iterable<AltroDebitiEntity>
     */
    public Iterable<AltroDebitiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroDebitiEntity>
     */
    public Iterable<AltroDebitiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroDebitiEntity>
     */
    public Optional<AltroDebitiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroDebitiEntity
     */
    public AltroDebitiEntity save(AltroDebitiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroDebitiEntity>
     */
    public Iterable<AltroDebitiEntity> saveAll(Iterable<AltroDebitiEntity> entities) {
        return repository.saveAll(entities);
    }
}
