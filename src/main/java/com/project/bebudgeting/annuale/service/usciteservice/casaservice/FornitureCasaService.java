package com.project.bebudgeting.annuale.service.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorycasa.FornitureCasaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FornitureCasaService {
    @Autowired
    FornitureCasaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(FornitureCasaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<FornitureCasaEntity> entities) {
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
            throw new NotFoundException("Item not Found");
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
    public Iterable<FornitureCasaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FornitureCasaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FornitureCasaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FornitureCasaEntity save(FornitureCasaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FornitureCasaEntity> saveAll(Iterable<FornitureCasaEntity> entities) {
        return repository.saveAll(entities);
    }
}
