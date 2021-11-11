package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.LavanderiaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.LavanderiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class LavanderiaService {
    @Autowired
    LavanderiaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(LavanderiaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<LavanderiaEntity> entities) {
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
    public Iterable<LavanderiaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<LavanderiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<LavanderiaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public LavanderiaEntity save(LavanderiaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<LavanderiaEntity> saveAll(Iterable<LavanderiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
