package com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.InteressiRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class InteressiService {
    @Autowired
    InteressiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(InteressiEntity entityToDelete)
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

    public void deleteAll(Iterable<InteressiEntity> enitiesToDelete) {
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
    public List<InteressiEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<InteressiEntity> ret = new ArrayList<InteressiEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    public Iterable<InteressiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<InteressiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<InteressiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public InteressiEntity save(InteressiEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<InteressiEntity> saveAll(Iterable<InteressiEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
