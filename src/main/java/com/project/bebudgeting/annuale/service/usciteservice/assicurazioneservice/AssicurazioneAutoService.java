package com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione.AssicurazioneAutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AssicurazioneAutoService {
    @Autowired
    AssicurazioneAutoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AssicurazioneAutoEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void deleteAll(Iterable<AssicurazioneAutoEntity> entitiesToDelete) {
        entitiesToDelete.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            repository.deleteById(id);
        });
    }

    // FIND
    public Iterable<AssicurazioneAutoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AssicurazioneAutoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AssicurazioneAutoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AssicurazioneAutoEntity save(AssicurazioneAutoEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AssicurazioneAutoEntity> saveAll(Iterable<AssicurazioneAutoEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
