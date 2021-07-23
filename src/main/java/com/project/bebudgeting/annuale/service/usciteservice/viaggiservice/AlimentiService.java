package com.project.bebudgeting.annuale.service.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AlimentiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi.AlimentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AlimentiService {
    @Autowired
    AlimentiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AlimentiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AlimentiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(alimentiEntity -> {
            try {
                this.delete(alimentiEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<AlimentiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AlimentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AlimentiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AlimentiEntity save(AlimentiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AlimentiEntity> saveAll(Iterable<AlimentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
