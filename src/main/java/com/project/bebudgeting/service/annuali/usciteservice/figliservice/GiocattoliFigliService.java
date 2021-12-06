package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.GiocattoliFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiocattoliFigliService {
    @Autowired
    GiocattoliFigliRepository repository;

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
    public void delete(GiocattoliFigliEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<GiocattoliFigliEntity> entities) {
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
     * @return Iterable<GiocattoliFigliEntity>
     */
    public Iterable<GiocattoliFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<GiocattoliFigliEntity>
     */
    public Iterable<GiocattoliFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<GiocattoliFigliEntity>
     */
    public Optional<GiocattoliFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return GiocattoliFigliEntity
     */
    public GiocattoliFigliEntity save(GiocattoliFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<GiocattoliFigliEntity>
     */
    public Iterable<GiocattoliFigliEntity> saveAll(Iterable<GiocattoliFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
