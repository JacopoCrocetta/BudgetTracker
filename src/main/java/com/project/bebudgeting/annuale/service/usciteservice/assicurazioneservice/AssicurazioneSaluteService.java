package com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione.AssicurazioneSaluteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AssicurazioneSaluteService {
    @Autowired
    AssicurazioneSaluteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AssicurazioneSaluteEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void deleteAll(Iterable<AssicurazioneSaluteEntity> entitiesToDelete) {
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
    public Iterable<AssicurazioneSaluteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AssicurazioneSaluteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AssicurazioneSaluteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AssicurazioneSaluteEntity save(AssicurazioneSaluteEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AssicurazioneSaluteEntity> saveAll(Iterable<AssicurazioneSaluteEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
