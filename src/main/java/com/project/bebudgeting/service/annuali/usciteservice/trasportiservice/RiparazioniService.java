package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.RiparazioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiparazioniService {
    @Autowired
    RiparazioniRepository repository;

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
    public void delete(RiparazioniEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<RiparazioniEntity> entities) {
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
     * @return Iterable<RiparazioniEntity>
     */
    public Iterable<RiparazioniEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RiparazioniEntity>
     */
    public Iterable<RiparazioniEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RiparazioniEntity>
     */
    public Optional<RiparazioniEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return RiparazioniEntity
     */
    public RiparazioniEntity save(RiparazioniEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RiparazioniEntity>
     */
    public Iterable<RiparazioniEntity> saveAll(Iterable<RiparazioniEntity> entities) {
        return repository.saveAll(entities);
    }
}
