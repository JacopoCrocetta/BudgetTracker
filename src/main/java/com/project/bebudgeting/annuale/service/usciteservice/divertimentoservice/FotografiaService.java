package com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento.FotografiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FotografiaService {
    @Autowired
    FotografiaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(FotografiaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<FotografiaEntity> entities) {
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
            throw new NotFoundException("Item not Found");
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
    public Iterable<FotografiaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FotografiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FotografiaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FotografiaEntity save(FotografiaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FotografiaEntity> saveAll(Iterable<FotografiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
