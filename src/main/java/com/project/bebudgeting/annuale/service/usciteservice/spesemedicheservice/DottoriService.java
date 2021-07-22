package com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesemediche.DottoriRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DottoriService {
    @Autowired
    DottoriRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(DottoriEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<DottoriEntity> entities) {
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
    public Iterable<DottoriEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<DottoriEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<DottoriEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public DottoriEntity save(DottoriEntity entity) {
        return repository.save(entity);
    }

    public Iterable<DottoriEntity> saveAll(Iterable<DottoriEntity> entities) {
        return repository.saveAll(entities);
    }
}
