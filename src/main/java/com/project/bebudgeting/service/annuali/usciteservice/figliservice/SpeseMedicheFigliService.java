package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.SpeseMedicheFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseMedicheFigliService {
    @Autowired
    SpeseMedicheFigliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(SpeseMedicheFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<SpeseMedicheFigliEntity> entities) {
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
    public Iterable<SpeseMedicheFigliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SpeseMedicheFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SpeseMedicheFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SpeseMedicheFigliEntity save(SpeseMedicheFigliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SpeseMedicheFigliEntity> saveAll(Iterable<SpeseMedicheFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
