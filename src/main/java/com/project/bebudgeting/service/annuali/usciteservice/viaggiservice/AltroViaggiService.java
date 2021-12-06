package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AltroViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.AltroViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroViaggiService {
    @Autowired
    AltroViaggiRepository repository;

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
    public void delete(AltroViaggiEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroViaggiEntity> entities) {
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
     * @return Iterable<AltroViaggiEntity>
     */
    public Iterable<AltroViaggiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroViaggiEntity>
     */
    public Iterable<AltroViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroViaggiEntity>
     */
    public Optional<AltroViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroViaggiEntity
     */
    public AltroViaggiEntity save(AltroViaggiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroViaggiEntity>
     */
    public Iterable<AltroViaggiEntity> saveAll(Iterable<AltroViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
