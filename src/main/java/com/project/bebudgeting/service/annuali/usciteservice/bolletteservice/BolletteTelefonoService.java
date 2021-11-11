package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTelefonoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteTelefonoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteTelefonoService {
    @Autowired
    BolletteTelefonoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteTelefonoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<BolletteTelefonoEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
    public Iterable<BolletteTelefonoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteTelefonoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteTelefonoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteTelefonoEntity save(BolletteTelefonoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteTelefonoEntity> saveAll(Iterable<BolletteTelefonoEntity> entities) {
        return repository.saveAll(entities);
    }
}
