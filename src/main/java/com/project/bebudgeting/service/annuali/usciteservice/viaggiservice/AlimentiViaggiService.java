package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.AlimentiViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimentiViaggiService {
    @Autowired
    AlimentiViaggiRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entityToDelete
     */
    public void delete(AlimentiViaggiEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AlimentiViaggiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(alimentiEntity -> {
            this.delete(alimentiEntity);
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
     * @return Iterable<AlimentiViaggiEntity>
     */
    public Iterable<AlimentiViaggiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AlimentiViaggiEntity>
     */
    public Iterable<AlimentiViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AlimentiViaggiEntity>
     */
    public Optional<AlimentiViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AlimentiViaggiEntity
     */
    public AlimentiViaggiEntity save(AlimentiViaggiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AlimentiViaggiEntity>
     */
    public Iterable<AlimentiViaggiEntity> saveAll(Iterable<AlimentiViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
