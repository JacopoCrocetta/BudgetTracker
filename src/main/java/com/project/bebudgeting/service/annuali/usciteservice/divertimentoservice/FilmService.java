package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    @Autowired
    FilmRepository repository;

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
    public void delete(FilmEntity entity) {
        repository.delete(entity);

    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<FilmEntity> entities) {
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
     * @return Iterable<FilmEntity>
     */
    public Iterable<FilmEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FilmEntity>
     */
    public Iterable<FilmEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FilmEntity>
     */
    public Optional<FilmEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return FilmEntity
     */
    public FilmEntity save(FilmEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FilmEntity>
     */
    public Iterable<FilmEntity> saveAll(Iterable<FilmEntity> entities) {
        return repository.saveAll(entities);
    }
}
