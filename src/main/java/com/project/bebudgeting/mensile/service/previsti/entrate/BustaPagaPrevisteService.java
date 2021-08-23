package com.project.bebudgeting.mensile.service.previsti.entrate;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.entrate.BustaPagaPrevisteEntity;
import com.project.bebudgeting.mensile.repository.previsti.entrate.BustaPagaPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BustaPagaPrevisteService {
    @Autowired
    BustaPagaPrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BustaPagaPrevisteEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<BustaPagaPrevisteEntity> entities) {
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
    public Iterable<BustaPagaPrevisteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BustaPagaPrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BustaPagaPrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BustaPagaPrevisteEntity save(BustaPagaPrevisteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BustaPagaPrevisteEntity> saveAll(Iterable<BustaPagaPrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}
