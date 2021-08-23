package com.project.bebudgeting.mensile.service.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.uscite.AltreUscitePrevisteEntity;
import com.project.bebudgeting.mensile.repository.previsti.uscite.AltreUscitePrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreUscitePrevisteService {
    @Autowired
    AltreUscitePrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltreUscitePrevisteEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<AltreUscitePrevisteEntity> entities) {
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
    public Iterable<AltreUscitePrevisteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltreUscitePrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltreUscitePrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltreUscitePrevisteEntity save(AltreUscitePrevisteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltreUscitePrevisteEntity> saveAll(Iterable<AltreUscitePrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}
