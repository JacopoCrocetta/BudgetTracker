package com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento.PartiteRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartiteService {
    @Autowired
    PartiteRepository repository;

    public long count() {
        return repository.count();
    }

    //DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(PartiteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<PartiteEntity> entities) {
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

    //FIND
    public Iterable<PartiteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<PartiteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<PartiteEntity> findById(int id) {
        return repository.findById(id);
    }

    //SAVE
    public PartiteEntity save(PartiteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<PartiteEntity> saveAll(Iterable<PartiteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
