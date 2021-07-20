package com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.LibriEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento.LibriRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class LibriService {
    @Autowired
    LibriRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(LibriEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<LibriEntity> entities) {
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
    public Iterable<LibriEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<LibriEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<LibriEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public LibriEntity save(LibriEntity entity) {
        return repository.save(entity);
    }

    public Iterable<LibriEntity> saveAll(Iterable<LibriEntity> entities) {
        return repository.saveAll(entities);
    }
}
