package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.AltroRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AltroAnimaliDomesticiService {
    @Autowired
    AltroRepository repository;

    public long count() {
        return repository.count();
    }

    //DELETE
    public void delete(AltroEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroEntity> entitiesToDelete) {
        entitiesToDelete.forEach(altroEntity -> {
            try {
                this.delete(altroEntity);
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

    //FIND
    public Iterable<AltroEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroEntity> findById(int id) {
        return repository.findById(id);
    }

    //SAVE
    public AltroEntity save(AltroEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroEntity> saveAll(Iterable<AltroEntity> entities) {
        return repository.saveAll(entities);
    }
}
