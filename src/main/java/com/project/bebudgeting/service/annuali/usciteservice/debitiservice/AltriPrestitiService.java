package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.AltriPrestitiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltriPrestitiService {
    @Autowired
    AltriPrestitiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltriPrestitiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltriPrestitiEntity> entities) {
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
    public Iterable<AltriPrestitiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltriPrestitiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltriPrestitiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltriPrestitiEntity save(AltriPrestitiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltriPrestitiEntity> saveAll(Iterable<AltriPrestitiEntity> entities) {
        return repository.saveAll(entities);
    }
}
