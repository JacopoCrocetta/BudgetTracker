package com.project.bebudgeting.annuale.service.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.FornitureEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti.FornitureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FornitureService {
    @Autowired
    FornitureRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(FornitureEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<FornitureEntity> entities) {
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
    public Iterable<FornitureEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<FornitureEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FornitureEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FornitureEntity save(FornitureEntity entity) {
        return repository.save(entity);
    }

    public Iterable<FornitureEntity> saveAll(Iterable<FornitureEntity> entities) {
        return repository.saveAll(entities);
    }
}
