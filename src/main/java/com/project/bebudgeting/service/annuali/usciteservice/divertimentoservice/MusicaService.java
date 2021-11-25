package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.MusicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {
    @Autowired
    MusicaRepository repository;

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
    public void delete(MusicaEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<MusicaEntity> entities) {
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
     * @return Iterable<MusicaEntity>
     */
    public Iterable<MusicaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<MusicaEntity>
     */
    public Iterable<MusicaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<MusicaEntity>
     */
    public Optional<MusicaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return MusicaEntity
     */
    public MusicaEntity save(MusicaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<MusicaEntity>
     */
    public Iterable<MusicaEntity> saveAll(Iterable<MusicaEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
