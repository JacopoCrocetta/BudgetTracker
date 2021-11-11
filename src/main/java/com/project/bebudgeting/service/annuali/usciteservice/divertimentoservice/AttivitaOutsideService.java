package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.AttivitaOutsideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AttivitaOutsideService {
    @Autowired
    AttivitaOutsideRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AttivitaOutsideEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AttivitaOutsideEntity> entities) {
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
            throw new NotFoundException("Item not Found");
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
    public Iterable<AttivitaOutsideEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AttivitaOutsideEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AttivitaOutsideEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AttivitaOutsideEntity save(AttivitaOutsideEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AttivitaOutsideEntity> saveAll(Iterable<AttivitaOutsideEntity> entities) {
        return repository.saveAll(entities);
    }
}
