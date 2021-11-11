package com.project.bebudgeting.service.mensili.effettivi.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.AltreEntrateEffettiveEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.entrate.AltreEntrateEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreEntrateEffettiveService {
    @Autowired
    AltreEntrateEffettiveRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltreEntrateEffettiveEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<AltreEntrateEffettiveEntity> entities) {
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
    public Iterable<AltreEntrateEffettiveEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltreEntrateEffettiveEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltreEntrateEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltreEntrateEffettiveEntity save(AltreEntrateEffettiveEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltreEntrateEffettiveEntity> saveAll(Iterable<AltreEntrateEffettiveEntity> entities) {
        return repository.saveAll(entities);
    }
}
