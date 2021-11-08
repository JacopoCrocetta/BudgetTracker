package com.project.bebudgeting.annuale.service.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AttivitaFigliEntity;
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
    public void delete(AttivitaFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AttivitaFigliEntity> entities) {
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
    public Iterable<AttivitaFigliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AttivitaFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AttivitaFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AttivitaFigliEntity save(AttivitaFigliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AttivitaFigliEntity> saveAll(Iterable<AttivitaFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
