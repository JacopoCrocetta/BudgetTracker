package com.project.bebudgeting.annuale.service.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorycasa.AltroCasaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroCasaService {
    @Autowired
    AltroCasaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroCasaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroCasaEntity> entities) {
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
    public Iterable<AltroCasaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroCasaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroCasaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroCasaEntity save(AltroCasaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroCasaEntity> saveAll(Iterable<AltroCasaEntity> entities) {
        return repository.saveAll(entities);
    }
}
