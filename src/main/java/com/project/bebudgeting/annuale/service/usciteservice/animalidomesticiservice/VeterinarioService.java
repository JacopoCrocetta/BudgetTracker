package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javassist.NotFoundException;

public class VeterinarioService {
    @Autowired
    VeterinarioRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(VeterinarioEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<VeterinarioEntity> entitiesToDelete) {
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
    public Iterable<VeterinarioEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<VeterinarioEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<VeterinarioEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public VeterinarioEntity save(VeterinarioEntity entity) {
        return repository.save(entity);
    }

    public Iterable<VeterinarioEntity> saveAll(Iterable<VeterinarioEntity> entities) {
        return repository.saveAll(entities);
    }
}
