package com.project.bebudgeting.annuale.service.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteGASEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorybollette.BolletteGASRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteGASService {
    @Autowired
    BolletteGASRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteGASEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<BolletteGASEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
    public Iterable<BolletteGASEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteGASEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteGASEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteGASEntity save(BolletteGASEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteGASEntity> saveAll(Iterable<BolletteGASEntity> entities) {
        return repository.saveAll(entities);
    }
}
