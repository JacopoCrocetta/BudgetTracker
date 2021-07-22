package com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.AbbonamentiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesequotidiane.AbbonamentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AbbonamentiService {
    @Autowired
    AbbonamentiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AbbonamentiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<AbbonamentiEntity> entities) {
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
    public Iterable<AbbonamentiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AbbonamentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AbbonamentiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AbbonamentiEntity save(AbbonamentiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AbbonamentiEntity> saveAll(Iterable<AbbonamentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
