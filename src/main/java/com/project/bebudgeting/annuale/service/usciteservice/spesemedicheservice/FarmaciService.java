package com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.FarmaciEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesemediche.FarmaciRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FarmaciService {
    @Autowired
    FarmaciRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(FarmaciEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<FarmaciEntity> entities) {
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
    public Iterable<FarmaciEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FarmaciEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FarmaciEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FarmaciEntity save(FarmaciEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FarmaciEntity> saveAll(Iterable<FarmaciEntity> entities) {
        return repository.saveAll(entities);
    }
}
