package com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.AltroEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryistruzione.AltroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroIstruzioneService {
    @Autowired
    AltroRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroEntity> entities) {
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
    public Iterable<AltroEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroEntity save(AltroEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroEntity> saveAll(Iterable<AltroEntity> entities) {
        return repository.saveAll(entities);
    }
}
