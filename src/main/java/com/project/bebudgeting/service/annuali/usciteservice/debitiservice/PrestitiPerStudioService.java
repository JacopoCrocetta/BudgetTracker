package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.PrestitiPerStudiareEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.PrestitiPerStudioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestitiPerStudioService {
    @Autowired
    PrestitiPerStudioRepository repository;

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
    public void delete(PrestitiPerStudiareEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<PrestitiPerStudiareEntity> entities) {
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
     * @return Iterable<PrestitiPerStudiareEntity>
     */
    public Iterable<PrestitiPerStudiareEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<PrestitiPerStudiareEntity>
     */
    public Iterable<PrestitiPerStudiareEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<PrestitiPerStudiareEntity>
     */
    public Optional<PrestitiPerStudiareEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return PrestitiPerStudiareEntity
     */
    public PrestitiPerStudiareEntity save(PrestitiPerStudiareEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<PrestitiPerStudiareEntity>
     */
    public Iterable<PrestitiPerStudiareEntity> saveAll(Iterable<PrestitiPerStudiareEntity> entities) {
        return repository.saveAll(entities);
    }
}
