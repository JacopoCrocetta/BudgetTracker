package com.project.bebudgeting.annuale.service.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi.BigliettiAereiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BigliettiAereiService {
    @Autowired
    BigliettiAereiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BigliettiAereiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<BigliettiAereiEntity> entities) {
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
    public Iterable<BigliettiAereiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BigliettiAereiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BigliettiAereiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BigliettiAereiEntity save(BigliettiAereiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BigliettiAereiEntity> saveAll(Iterable<BigliettiAereiEntity> entities) {
        return repository.saveAll(entities);
    }
}
