package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.ScuolaFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.ScuolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ScuolaFigliService {
    @Autowired
    ScuolaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(ScuolaFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<ScuolaFigliEntity> entities) {
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
    public Iterable<ScuolaFigliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<ScuolaFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<ScuolaFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public ScuolaFigliEntity save(ScuolaFigliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<ScuolaFigliEntity> saveAll(Iterable<ScuolaFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
