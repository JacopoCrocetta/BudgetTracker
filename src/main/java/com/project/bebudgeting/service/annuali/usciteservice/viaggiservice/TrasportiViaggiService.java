package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.TrasportiViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.TrasportiViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrasportiViaggiService {
    @Autowired
    TrasportiViaggiRepository repository;

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
    public void delete(TrasportiViaggiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<TrasportiViaggiEntity> entities) {
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
     * @return Iterable<TrasportiViaggiEntity>
     */
    public Iterable<TrasportiViaggiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TrasportiViaggiEntity>
     */
    public Iterable<TrasportiViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TrasportiViaggiEntity>
     */
    public Optional<TrasportiViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return TrasportiViaggiEntity
     */
    public TrasportiViaggiEntity save(TrasportiViaggiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TrasportiViaggiEntity>
     */
    public Iterable<TrasportiViaggiEntity> saveAll(Iterable<TrasportiViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
