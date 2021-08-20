package com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryistruzione.AltroIstruzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroIstruzioneService {
    @Autowired
    AltroIstruzioneRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroIstruzioneEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroIstruzioneEntity> entities) {
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
    public Iterable<AltroIstruzioneEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroIstruzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroIstruzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroIstruzioneEntity save(AltroIstruzioneEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroIstruzioneEntity> saveAll(Iterable<AltroIstruzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
