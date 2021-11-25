package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.AltreBolletteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.AltreBolletteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreBolletteService {
    @Autowired
    AltreBolletteRepository repository;

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
    public void delete(AltreBolletteEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltreBolletteEntity> entities) {
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
     * @return Iterable<AltreBolletteEntity>
     */
    public Iterable<AltreBolletteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltreBolletteEntity>
     */
    public Iterable<AltreBolletteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltreBolletteEntity>
     */
    public Optional<AltreBolletteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltreBolletteEntity
     */
    public AltreBolletteEntity save(AltreBolletteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltreBolletteEntity>
     */
    public Iterable<AltreBolletteEntity> saveAll(Iterable<AltreBolletteEntity> entities) {
        return repository.saveAll(entities);
    }
}
