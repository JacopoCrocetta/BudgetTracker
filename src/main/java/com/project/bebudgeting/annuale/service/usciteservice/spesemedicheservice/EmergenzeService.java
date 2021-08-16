package com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesemediche.EmergenzeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EmergenzeService {
    @Autowired
    EmergenzeRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(EmergenzeEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<EmergenzeEntity> entities) {
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
    public Iterable<EmergenzeEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<EmergenzeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<EmergenzeEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public EmergenzeEntity save(EmergenzeEntity entity) {
        return repository.save(entity);
    }

    public Iterable<EmergenzeEntity> saveAll(Iterable<EmergenzeEntity> entities) {
        return repository.saveAll(entities);
    }
}