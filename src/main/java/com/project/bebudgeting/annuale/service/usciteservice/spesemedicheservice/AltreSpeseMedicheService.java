package com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.AltroSpeseMedicheEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesemediche.AltroSpeseMedicheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreSpeseMedicheService {
    @Autowired
    AltroSpeseMedicheRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltroSpeseMedicheEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<AltroSpeseMedicheEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
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
    public Iterable<AltroSpeseMedicheEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroSpeseMedicheEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroSpeseMedicheEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroSpeseMedicheEntity save(AltroSpeseMedicheEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroSpeseMedicheEntity> saveAll(Iterable<AltroSpeseMedicheEntity> entities) {
        return repository.saveAll(entities);
    }
}
