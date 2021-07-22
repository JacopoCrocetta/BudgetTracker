package com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.RistorantiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryspesequotidiane.RistorantiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RistorantiService {
    @Autowired
    RistorantiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(RistorantiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<RistorantiEntity> entities) {
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
    public Iterable<RistorantiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RistorantiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RistorantiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RistorantiEntity save(RistorantiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RistorantiEntity> saveAll(Iterable<RistorantiEntity> entities) {
        return repository.saveAll(entities);
    }
}
