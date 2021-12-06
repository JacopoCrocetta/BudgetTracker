package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.BigliettiAereiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigliettiAereiService {
    @Autowired
    BigliettiAereiRepository repository;

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
    public void delete(BigliettiAereiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BigliettiAereiEntity> entities) {
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
     * @return Iterable<BigliettiAereiEntity>
     */
    public Iterable<BigliettiAereiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BigliettiAereiEntity>
     */
    public Iterable<BigliettiAereiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BigliettiAereiEntity>
     */
    public Optional<BigliettiAereiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return BigliettiAereiEntity
     */
    public BigliettiAereiEntity save(BigliettiAereiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BigliettiAereiEntity>
     */
    public Iterable<BigliettiAereiEntity> saveAll(Iterable<BigliettiAereiEntity> entities) {
        return repository.saveAll(entities);
    }
}
