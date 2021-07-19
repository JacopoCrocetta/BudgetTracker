package com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryassicurazione.AssicurazioneCasaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AssicurazioneCasaService {
    @Autowired
    AssicurazioneCasaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AssicurazioneCasaEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void deleteAll(Iterable<AssicurazioneCasaEntity> entitiesToDelete) {
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
    public Iterable<AssicurazioneCasaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AssicurazioneCasaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AssicurazioneCasaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AssicurazioneCasaEntity save(AssicurazioneCasaEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AssicurazioneCasaEntity> saveAll(Iterable<AssicurazioneCasaEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
