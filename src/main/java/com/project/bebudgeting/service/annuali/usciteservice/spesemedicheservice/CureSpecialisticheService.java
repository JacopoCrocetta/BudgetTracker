package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.CureSpecialisticheEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.CureSpecialisticheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CureSpecialisticheService {
    @Autowired
    CureSpecialisticheRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(CureSpecialisticheEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<CureSpecialisticheEntity> entities) {
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
    public Iterable<CureSpecialisticheEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<CureSpecialisticheEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<CureSpecialisticheEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public CureSpecialisticheEntity save(CureSpecialisticheEntity entity) {
        return repository.save(entity);
    }

    public Iterable<CureSpecialisticheEntity> saveAll(Iterable<CureSpecialisticheEntity> entities) {
        return repository.saveAll(entities);
    }
}
