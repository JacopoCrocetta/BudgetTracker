package com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.RimborsiRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RimborsiService {
    @Autowired
    RimborsiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(RimborsiEntity entityToDelete)
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

    public void deleteAll(Iterable<RimborsiEntity> enitiesToDelete) {
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
    public List<RimborsiEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<RimborsiEntity> ret = new ArrayList<RimborsiEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    public Iterable<RimborsiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RimborsiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RimborsiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RimborsiEntity save(RimborsiEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<RimborsiEntity> saveAll(Iterable<RimborsiEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
