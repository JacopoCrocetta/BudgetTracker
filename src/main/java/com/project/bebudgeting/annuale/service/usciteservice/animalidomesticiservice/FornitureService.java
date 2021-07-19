package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.FornitureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FornitureService {
    @Autowired
    FornitureRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(FornitureEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<FornitureEntity> entitiesToDelete) {
        entitiesToDelete.forEach(fornitureEntity -> {
            try {
                this.delete(fornitureEntity);
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
    public Iterable<FornitureEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FornitureEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FornitureEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FornitureEntity save(FornitureEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FornitureEntity> saveAll(Iterable<FornitureEntity> entities) {
        return repository.saveAll(entities);
    }
}
