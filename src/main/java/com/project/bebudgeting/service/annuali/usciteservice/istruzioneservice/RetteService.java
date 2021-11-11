package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.RetteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.RetteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RetteService {
    @Autowired
    RetteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(RetteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<RetteEntity> entities) {
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
    public Iterable<RetteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RetteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RetteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RetteEntity save(RetteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RetteEntity> saveAll(Iterable<RetteEntity> entities) {
        return repository.saveAll(entities);
    }
}
