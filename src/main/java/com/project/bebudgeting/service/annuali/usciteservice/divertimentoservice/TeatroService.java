package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TeatroEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.TeatroRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeatroService {
    @Autowired
    TeatroRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(TeatroEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<TeatroEntity> entities) {
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
    public Iterable<TeatroEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<TeatroEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<TeatroEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public TeatroEntity save(TeatroEntity entity) {
        return repository.save(entity);
    }

    public Iterable<TeatroEntity> saveAll(Iterable<TeatroEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
