package com.project.bebudgeting.annuale.service.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AttivitaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli.AttivitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AttivitaFigliService {
    @Autowired
    AttivitaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AttivitaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AttivitaEntity> entities) {
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
    public Iterable<AttivitaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AttivitaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AttivitaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AttivitaEntity save(AttivitaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AttivitaEntity> saveAll(Iterable<AttivitaEntity> entities) {
        return repository.saveAll(entities);
    }
}
