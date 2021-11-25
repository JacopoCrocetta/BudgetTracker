package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinarioAnimaliDomesticiService {
    @Autowired
    VeterinarioRepository repository;

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
    public void delete(VeterinarioAnimaliDomesticiEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<VeterinarioAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(veterinarioEntity -> {
            this.delete(veterinarioEntity);
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
     * @return Iterable<VeterinarioAnimaliDomesticiEntity>
     */
    public Iterable<VeterinarioAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<VeterinarioAnimaliDomesticiEntity>
     */
    public Iterable<VeterinarioAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<VeterinarioAnimaliDomesticiEntity>
     */
    public Optional<VeterinarioAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return VeterinarioAnimaliDomesticiEntity
     */
    public VeterinarioAnimaliDomesticiEntity save(VeterinarioAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<VeterinarioAnimaliDomesticiEntity>
     */
    public Iterable<VeterinarioAnimaliDomesticiEntity> saveAll(Iterable<VeterinarioAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
