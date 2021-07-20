package com.project.bebudgeting.annuale.service.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.TraslocoEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorycasa.TraslocoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TraslocoService {
    @Autowired
    TraslocoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(TraslocoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<TraslocoEntity> entities) {
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
    public Iterable<TraslocoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<TraslocoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<TraslocoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public TraslocoEntity save(TraslocoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<TraslocoEntity> saveAll(Iterable<TraslocoEntity> entities) {
        return repository.saveAll(entities);
    }
}
