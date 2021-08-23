package com.project.bebudgeting.mensile.service.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.uscite.BollettePrevisteEntity;
import com.project.bebudgeting.mensile.repository.previsti.uscite.BollettePrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BollettePrevisteService {
    @Autowired
    BollettePrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BollettePrevisteEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<BollettePrevisteEntity> entities) {
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
    public Iterable<BollettePrevisteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BollettePrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BollettePrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BollettePrevisteEntity save(BollettePrevisteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BollettePrevisteEntity> saveAll(Iterable<BollettePrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}