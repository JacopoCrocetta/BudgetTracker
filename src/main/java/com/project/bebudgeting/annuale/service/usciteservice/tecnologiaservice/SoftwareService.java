package com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.SoftwareEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorytecnologia.SoftwareRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SoftwareService {
    @Autowired
    SoftwareRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(SoftwareEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<SoftwareEntity> entities) {
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
    public Iterable<SoftwareEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SoftwareEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SoftwareEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SoftwareEntity save(SoftwareEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SoftwareEntity> saveAll(Iterable<SoftwareEntity> entities) {
        return repository.saveAll(entities);
    }
}
