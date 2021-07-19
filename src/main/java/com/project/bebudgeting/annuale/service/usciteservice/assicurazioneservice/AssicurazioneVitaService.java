package com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione.AssicurazioneVitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AssicurazioneVitaService {
    @Autowired
    AssicurazioneVitaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AssicurazioneVitaEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void deleteAll(Iterable<AssicurazioneVitaEntity> entitiesToDelete) {
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
    public Iterable<AssicurazioneVitaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AssicurazioneVitaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AssicurazioneVitaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AssicurazioneVitaEntity save(AssicurazioneVitaEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AssicurazioneVitaEntity> saveAll(Iterable<AssicurazioneVitaEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
