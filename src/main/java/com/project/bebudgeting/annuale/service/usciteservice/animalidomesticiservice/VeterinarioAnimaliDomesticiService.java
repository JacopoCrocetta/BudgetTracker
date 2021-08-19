package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javassist.NotFoundException;

public class VeterinarioAnimaliDomesticiService {
    @Autowired
    VeterinarioRepository repository;

    public long count() {
        return repository.count();
    }

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

    public void deleteAll(Iterable<VeterinarioAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(veterinarioEntity -> {
            try {
                this.delete(veterinarioEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<VeterinarioAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<VeterinarioAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<VeterinarioAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public VeterinarioAnimaliDomesticiEntity save(VeterinarioAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<VeterinarioAnimaliDomesticiEntity> saveAll(Iterable<VeterinarioAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
