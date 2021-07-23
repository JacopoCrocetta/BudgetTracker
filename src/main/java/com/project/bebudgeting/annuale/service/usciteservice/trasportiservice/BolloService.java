package com.project.bebudgeting.annuale.service.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti.BolloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolloService {
    @Autowired
    BolloRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BolloEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<BolloEntity> entities) {
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
    public Iterable<BolloEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolloEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolloEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolloEntity save(BolloEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolloEntity> saveAll(Iterable<BolloEntity> entities) {
        return repository.saveAll(entities);
    }
}
