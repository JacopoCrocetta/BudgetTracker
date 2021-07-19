package com.project.bebudgeting.annuale.service.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteAcquaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorybollette.BolletteAcquaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteAcquaService {
    @Autowired
    BolletteAcquaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteAcquaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<BolletteAcquaEntity> entities) {
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
    public Iterable<BolletteAcquaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteAcquaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteAcquaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteAcquaEntity save(BolletteAcquaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteAcquaEntity> saveAll(Iterable<BolletteAcquaEntity> entities) {
        return repository.saveAll(entities);
    }
}
