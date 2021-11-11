package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AltreAssicurazioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreAssicurazioniService {
    @Autowired
    AltreAssicurazioniRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltreAssicurazioniEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void deleteAll(List<AltreAssicurazioniEntity> entitiesToDelete) {
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
    public Iterable<AltreAssicurazioniEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltreAssicurazioniEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltreAssicurazioniEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltreAssicurazioniEntity save(AltreAssicurazioniEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AltreAssicurazioniEntity> saveAll(Iterable<AltreAssicurazioniEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
