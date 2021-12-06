package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.AltroTrasportiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.AltroTrasportiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroTrasportiService {
    @Autowired
    AltroTrasportiRepository repository;

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
     */
    public void delete(AltroTrasportiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroTrasportiEntity> entities) {
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
     * @return Iterable<AltroTrasportiEntity>
     */
    public Iterable<AltroTrasportiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroTrasportiEntity>
     */
    public Iterable<AltroTrasportiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroTrasportiEntity>
     */
    public Optional<AltroTrasportiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroTrasportiEntity
     */
    public AltroTrasportiEntity save(AltroTrasportiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroTrasportiEntity>
     */
    public Iterable<AltroTrasportiEntity> saveAll(Iterable<AltroTrasportiEntity> entities) {
        return repository.saveAll(entities);
    }
}
