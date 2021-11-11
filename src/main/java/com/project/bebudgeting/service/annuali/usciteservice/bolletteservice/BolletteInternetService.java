package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteInternetEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteInternetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteInternetService {
    @Autowired
    BolletteInternetRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteInternetEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<BolletteInternetEntity> entities) {
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
    public Iterable<BolletteInternetEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteInternetEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteInternetEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteInternetEntity save(BolletteInternetEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteInternetEntity> saveAll(Iterable<BolletteInternetEntity> entities) {
        return repository.saveAll(entities);
    }
}
