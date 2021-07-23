package com.project.bebudgeting.annuale.service.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.TrasportiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi.TrasportiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TrasportiService {
    @Autowired
    TrasportiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(TrasportiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<TrasportiEntity> entities) {
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
    public Iterable<TrasportiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<TrasportiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<TrasportiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public TrasportiEntity save(TrasportiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<TrasportiEntity> saveAll(Iterable<TrasportiEntity> entities) {
        return repository.saveAll(entities);
    }
}
