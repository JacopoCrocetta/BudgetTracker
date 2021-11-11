package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.SportRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportService {
    @Autowired
    SportRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(SportEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<SportEntity> entities) {
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
    public Iterable<SportEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SportEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SportEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SportEntity save(SportEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SportEntity> saveAll(Iterable<SportEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
