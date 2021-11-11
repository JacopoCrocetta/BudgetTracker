package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.AltroRegaliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.AltroRegaliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroRegaliService {
    @Autowired
    AltroRegaliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroRegaliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroRegaliEntity> entities) {
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
    public Iterable<AltroRegaliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroRegaliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroRegaliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroRegaliEntity save(AltroRegaliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroRegaliEntity> saveAll(Iterable<AltroRegaliEntity> entities) {
        return repository.saveAll(entities);
    }
}
