package com.project.bebudgeting.annuale.service.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.PaghettaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli.PaghettaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class PaghettaFigliService {
    @Autowired
    PaghettaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(PaghettaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<PaghettaEntity> entities) {
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
    public Iterable<PaghettaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<PaghettaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<PaghettaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public PaghettaEntity save(PaghettaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<PaghettaEntity> saveAll(Iterable<PaghettaEntity> entities) {
        return repository.saveAll(entities);
    }
}
