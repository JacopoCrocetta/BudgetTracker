package com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositorydettaglisalario.BonusRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BonusService {
    @Autowired
    BonusRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BonusEntity entityToDelete)
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

    public void deleteAll(Iterable<BonusEntity> enitiesToDelete) {
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
    public Iterable<BonusEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BonusEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BonusEntity> findById(int id) {
        return repository.findById(id);
    }

    public List<BonusEntity> findBySalarioId(int salarioId) {
        List<BonusEntity> ret = new ArrayList<BonusEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    // SAVE
    public BonusEntity save(BonusEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<BonusEntity> saveAll(Iterable<BonusEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
