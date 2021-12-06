package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.ServiziOnlineEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.ServiziOnlineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiziOnlineService {
    @Autowired
    ServiziOnlineRepository repository;

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
    public void delete(ServiziOnlineEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ServiziOnlineEntity> entities) {
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
     * @return Iterable<ServiziOnlineEntity>
     */
    public Iterable<ServiziOnlineEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ServiziOnlineEntity>
     */
    public Iterable<ServiziOnlineEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ServiziOnlineEntity>
     */
    public Optional<ServiziOnlineEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return ServiziOnlineEntity
     */
    public ServiziOnlineEntity save(ServiziOnlineEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ServiziOnlineEntity>
     */
    public Iterable<ServiziOnlineEntity> saveAll(Iterable<ServiziOnlineEntity> entities) {
        return repository.saveAll(entities);
    }
}
