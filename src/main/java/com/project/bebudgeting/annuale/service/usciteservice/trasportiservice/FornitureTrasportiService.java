package com.project.bebudgeting.annuale.service.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.FornitureTrasportiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti.FornitureTrasportiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FornitureTrasportiService {
    @Autowired
    FornitureTrasportiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(FornitureTrasportiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<FornitureTrasportiEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
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
    public Iterable<FornitureTrasportiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FornitureTrasportiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FornitureTrasportiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FornitureTrasportiEntity save(FornitureTrasportiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FornitureTrasportiEntity> saveAll(Iterable<FornitureTrasportiEntity> entities) {
        return repository.saveAll(entities);
    }
}
