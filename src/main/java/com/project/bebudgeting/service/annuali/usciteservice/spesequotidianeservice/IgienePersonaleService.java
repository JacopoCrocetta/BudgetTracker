package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.IgienePersonaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IgienePersonaleService {
    @Autowired
    IgienePersonaleRepository repository;

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
    public void delete(IgienePersonaleEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<IgienePersonaleEntity> entities) {
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
     * @return Iterable<IgienePersonaleEntity>
     */
    public Iterable<IgienePersonaleEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<IgienePersonaleEntity>
     */
    public Iterable<IgienePersonaleEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<IgienePersonaleEntity>
     */
    public Optional<IgienePersonaleEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return IgienePersonaleEntity
     */
    public IgienePersonaleEntity save(IgienePersonaleEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<IgienePersonaleEntity>
     */
    public Iterable<IgienePersonaleEntity> saveAll(Iterable<IgienePersonaleEntity> entities) {
        return repository.saveAll(entities);
    }
}
