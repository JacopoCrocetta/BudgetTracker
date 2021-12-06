package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.RegaliDBEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.RegaliDBRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegaliDBService {
    @Autowired
    RegaliDBRepository repository;

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
    public void delete(RegaliDBEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<RegaliDBEntity> entities) {
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
     * @return Iterable<RegaliDBEntity>
     */

    public Iterable<RegaliDBEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RegaliDBEntity>
     */
    public Iterable<RegaliDBEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RegaliDBEntity>
     */
    public Optional<RegaliDBEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return RegaliDBEntity
     */
    public RegaliDBEntity save(RegaliDBEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RegaliDBEntity>
     */
    public Iterable<RegaliDBEntity> saveAll(Iterable<RegaliDBEntity> entities) {
        return repository.saveAll(entities);
    }
}
