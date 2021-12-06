package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HostingEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.HostingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostingService {
    @Autowired
    HostingRepository repository;

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
    public void delete(HostingEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<HostingEntity> entities) {
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
     * @return Iterable<HostingEntity>
     */
    public Iterable<HostingEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<HostingEntity>
     */
    public Iterable<HostingEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<HostingEntity>
     */
    public Optional<HostingEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return HostingEntity
     */
    public HostingEntity save(HostingEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<HostingEntity>
     */
    public Iterable<HostingEntity> saveAll(Iterable<HostingEntity> entities) {
        return repository.saveAll(entities);
    }
}
