package com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento.ConcertiOSpettacoliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ConcertiOSpettacoliService {
    @Autowired
    ConcertiOSpettacoliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(ConcertiOSpettacoliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<ConcertiOSpettacoliEntity> entities) {
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
    public Iterable<ConcertiOSpettacoliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<ConcertiOSpettacoliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<ConcertiOSpettacoliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public ConcertiOSpettacoliEntity save(ConcertiOSpettacoliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<ConcertiOSpettacoliEntity> saveAll(Iterable<ConcertiOSpettacoliEntity> entities) {
        return repository.saveAll(entities);
    }
}