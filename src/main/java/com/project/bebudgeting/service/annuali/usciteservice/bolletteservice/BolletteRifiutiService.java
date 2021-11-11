package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteRifiutiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteRifiutiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteRifiutiService {
    @Autowired
    BolletteRifiutiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteRifiutiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<BolletteRifiutiEntity> entities) {
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
    public Iterable<BolletteRifiutiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteRifiutiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteRifiutiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteRifiutiEntity save(BolletteRifiutiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteRifiutiEntity> saveAll(Iterable<BolletteRifiutiEntity> entities) {
        return repository.saveAll(entities);
    }
}
