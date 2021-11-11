package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(VeterinarioAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<VeterinarioAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(veterinarioEntity -> {
            try {
                this.delete(veterinarioEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<VeterinarioAnimaliDomesticiEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return VeterinarioAnimaliDomesticiEntity
     */
    // SAVE
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
