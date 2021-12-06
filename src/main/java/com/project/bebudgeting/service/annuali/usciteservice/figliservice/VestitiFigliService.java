package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.VestitiFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.VestitiFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VestitiFigliService {
    @Autowired
    VestitiFigliRepository repository;

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
    public void delete(VestitiFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<VestitiFigliEntity> entities) {
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
     * @return Iterable<VestitiFigliEntity>
     */
    public Iterable<VestitiFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<VestitiFigliEntity>
     */
    public Iterable<VestitiFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<VestitiFigliEntity>
     */
    public Optional<VestitiFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return VestitiFigliEntity
     */
    public VestitiFigliEntity save(VestitiFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<VestitiFigliEntity>
     */
    public Iterable<VestitiFigliEntity> saveAll(Iterable<VestitiFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
