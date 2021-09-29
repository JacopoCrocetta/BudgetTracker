package com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositorydettaglisalario.BustaPagaRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BustaPagaService {
    @Autowired
    BustaPagaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BustaPagaEntity entityToDelete)
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

    public boolean deleteAll(Iterable<BustaPagaEntity> entitiesToDelete) {
        List<Integer> ids = new ArrayList<>();
        entitiesToDelete.forEach(entity -> {
            ids.add(entity.getId());
        });
        entitiesToDelete.forEach(entity -> {
            try {
                delete(entity);
            } catch (NotImplementedException | NullPointerException | NotFoundException e) {
                e.printStackTrace();
            }
        });
        if (repository.findAllById(ids) != null) {
            return true;
        } else {
            return false;
        }
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
    public Iterable<BustaPagaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BustaPagaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BustaPagaEntity> findById(int id) {
        return repository.findById(id);
    }

    public List<BustaPagaEntity> findBySalarioId(int salarioId) {
        List<BustaPagaEntity> ret = new ArrayList<BustaPagaEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    // SAVE
    public BustaPagaEntity save(BustaPagaEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<BustaPagaEntity> saveAll(Iterable<BustaPagaEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
