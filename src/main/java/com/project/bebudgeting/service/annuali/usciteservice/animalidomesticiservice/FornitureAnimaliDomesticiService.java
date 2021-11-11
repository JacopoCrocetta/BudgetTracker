package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.FornitureAnimaliDomesticiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FornitureAnimaliDomesticiService {
    @Autowired
    FornitureAnimaliDomesticiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(FornitureAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<FornitureAnimaliDomesticiEntity> entitiesToDelete) {
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
    public Iterable<FornitureAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FornitureAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FornitureAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FornitureAnimaliDomesticiEntity save(FornitureAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FornitureAnimaliDomesticiEntity> saveAll(Iterable<FornitureAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
