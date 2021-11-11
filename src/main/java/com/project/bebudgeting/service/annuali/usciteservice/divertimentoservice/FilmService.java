package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(FilmEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<FilmEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not Found");
        }
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<FilmEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return FilmEntity
     */
    // SAVE
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
