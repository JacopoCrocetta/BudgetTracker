package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.VestitiSpeseQuotidianeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VestitiService {
    @Autowired
    VestitiSpeseQuotidianeRepository repository;

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
    public void delete(VestitiSpeseQuotidianeEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<VestitiSpeseQuotidianeEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    /**
     * @param id
     * @throws NotFoundException
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
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    public Iterable<VestitiSpeseQuotidianeEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    public Iterable<VestitiSpeseQuotidianeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<VestitiSpeseQuotidianeEntity>
     */
    public Optional<VestitiSpeseQuotidianeEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return VestitiSpeseQuotidianeEntity
     */
    public VestitiSpeseQuotidianeEntity save(VestitiSpeseQuotidianeEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    public Iterable<VestitiSpeseQuotidianeEntity> saveAll(Iterable<VestitiSpeseQuotidianeEntity> entities) {
        return repository.saveAll(entities);
    }
}
