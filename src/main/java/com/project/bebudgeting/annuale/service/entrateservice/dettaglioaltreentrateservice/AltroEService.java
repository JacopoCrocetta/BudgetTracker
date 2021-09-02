package com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.AltroAltreEntrateRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroEService {
    @Autowired
    AltroAltreEntrateRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroAltreEntrateEntity entityToDelete)
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

    public void deleteAll(Iterable<AltroAltreEntrateEntity> enitiesToDelete) {
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
    public List<AltroAltreEntrateEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<AltroAltreEntrateEntity> ret = new ArrayList<AltroAltreEntrateEntity>();
        repository.findAll().forEach(entity -> {
            if (entity.getAltreEntrateEntityEntity().getId() == altreEntrateId) {
                ret.add(entity);
            }
        });
        return ret;
    }

    public Iterable<AltroAltreEntrateEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroAltreEntrateEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroAltreEntrateEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroAltreEntrateEntity save(AltroAltreEntrateEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<AltroAltreEntrateEntity> saveAll(Iterable<AltroAltreEntrateEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}