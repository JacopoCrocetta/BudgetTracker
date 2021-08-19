package com.project.bebudgeting.annuale.service.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi.AlimentiViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AlimentiViaggiService {
    @Autowired
    AlimentiViaggiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AlimentiViaggiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AlimentiViaggiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(alimentiEntity -> {
            try {
                this.delete(alimentiEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
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
    public Iterable<AlimentiViaggiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AlimentiViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AlimentiViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AlimentiViaggiEntity save(AlimentiViaggiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AlimentiViaggiEntity> saveAll(Iterable<AlimentiViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
