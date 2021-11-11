package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.AltroFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.AltroFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroFigliService {
    @Autowired
    AltroFigliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroFigliEntity> entities) {
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
    public Iterable<AltroFigliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroFigliEntity save(AltroFigliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroFigliEntity> saveAll(Iterable<AltroFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
