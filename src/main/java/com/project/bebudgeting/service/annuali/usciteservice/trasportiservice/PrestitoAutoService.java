package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.PrestitoAutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class PrestitoAutoService {
    @Autowired
    PrestitoAutoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(PrestitoAutoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<PrestitoAutoEntity> entities) {
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
    public Iterable<PrestitoAutoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<PrestitoAutoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<PrestitoAutoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public PrestitoAutoEntity save(PrestitoAutoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<PrestitoAutoEntity> saveAll(Iterable<PrestitoAutoEntity> entities) {
        return repository.saveAll(entities);
    }
}
