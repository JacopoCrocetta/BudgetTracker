package com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RegaliEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.RegaliRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliService {
    @Autowired
    RegaliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(RegaliEntity entityToDelete)
            throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null)
            throw new NullPointerException("Item is not set");
        if (repository.existsById(entityToDelete.getId()))
            repository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<RegaliEntity> enitiesToDelete) {
        enitiesToDelete.forEach(entity -> {
            try {
                delete(entity);
            } catch (NotImplementedException | NullPointerException | NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id))
            repository.deleteById(id);
        throw new NotFoundException("Item not found");
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<RegaliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RegaliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RegaliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RegaliEntity save(RegaliEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<RegaliEntity> saveAll(Iterable<RegaliEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
