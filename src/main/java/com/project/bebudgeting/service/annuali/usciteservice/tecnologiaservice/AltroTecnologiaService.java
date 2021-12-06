package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.AltroTecnologiaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.AltroTecnologiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroTecnologiaService {
    @Autowired
    AltroTecnologiaRepository repository;

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
    public void delete(AltroTecnologiaEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroTecnologiaEntity> entities) {
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
     * @return Iterable<AltroTecnologiaEntity>
     */
    public Iterable<AltroTecnologiaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroTecnologiaEntity>
     */
    public Iterable<AltroTecnologiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroTecnologiaEntity>
     */
    public Optional<AltroTecnologiaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroTecnologiaEntity
     */
    public AltroTecnologiaEntity save(AltroTecnologiaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroTecnologiaEntity>
     */
    public Iterable<AltroTecnologiaEntity> saveAll(Iterable<AltroTecnologiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
