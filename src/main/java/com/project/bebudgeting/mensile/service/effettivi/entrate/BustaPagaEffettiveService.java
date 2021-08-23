package com.project.bebudgeting.mensile.service.effettivi.entrate;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.entrate.BustaPagaEffettiveEntity;
import com.project.bebudgeting.mensile.repository.effettivi.entrate.BustaPagaEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BustaPagaEffettiveService {
    @Autowired
    BustaPagaEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BustaPagaEffettiveEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<BustaPagaEffettiveEntity> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAllByID(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<BustaPagaEffettiveEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BustaPagaEffettiveEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BustaPagaEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BustaPagaEffettiveEntity save(BustaPagaEffettiveEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BustaPagaEffettiveEntity> saveAll(Iterable<BustaPagaEffettiveEntity> entities) {
        return repository.saveAll(entities);
    }
}
