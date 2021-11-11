package com.project.bebudgeting.service.mensili.previsti.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.entrate.AltreEntratePrevisteEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.entrate.AltreEntratePrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreEntratePrevisteService {
    @Autowired
    AltreEntratePrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltreEntratePrevisteEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<AltreEntratePrevisteEntity> entities) {
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
    public Iterable<AltreEntratePrevisteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltreEntratePrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltreEntratePrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltreEntratePrevisteEntity save(AltreEntratePrevisteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltreEntratePrevisteEntity> saveAll(Iterable<AltreEntratePrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}
