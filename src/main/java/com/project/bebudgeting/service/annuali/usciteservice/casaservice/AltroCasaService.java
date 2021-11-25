package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.AltroCasaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroCasaService {
    @Autowired
    AltroCasaRepository repository;

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
    public void delete(AltroCasaEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroCasaEntity> entities) {
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
     * @return Iterable<AltroCasaEntity>
     */
    public Iterable<AltroCasaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroCasaEntity>
     */
    public Iterable<AltroCasaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroCasaEntity>
     */
    public Optional<AltroCasaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroCasaEntity
     */
    public AltroCasaEntity save(AltroCasaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroCasaEntity>
     */
    public Iterable<AltroCasaEntity> saveAll(Iterable<AltroCasaEntity> entities) {
        return repository.saveAll(entities);
    }
}
