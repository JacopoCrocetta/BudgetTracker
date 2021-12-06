package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.DivertimentoViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.DivertimentoViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivertimentoViaggiService {
    @Autowired
    DivertimentoViaggiRepository repository;

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
    public void delete(DivertimentoViaggiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<DivertimentoViaggiEntity> entities) {
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
     * @return Iterable<DivertimentoViaggiEntity>
     */
    public Iterable<DivertimentoViaggiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<DivertimentoViaggiEntity>
     */
    public Iterable<DivertimentoViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<DivertimentoViaggiEntity>
     */
    public Optional<DivertimentoViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return DivertimentoViaggiEntity
     */
    public DivertimentoViaggiEntity save(DivertimentoViaggiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<DivertimentoViaggiEntity>
     */
    public Iterable<DivertimentoViaggiEntity> saveAll(Iterable<DivertimentoViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
