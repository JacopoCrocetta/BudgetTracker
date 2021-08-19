package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.AltroAnimaliDomesticiRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AltroAnimaliDomesticiService {
    @Autowired
    AltroAnimaliDomesticiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroAnimaliDomesticiEntity> entitiesToDelete) {
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

    // FIND
    public Iterable<AltroAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroAnimaliDomesticiEntity save(AltroAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroAnimaliDomesticiEntity> saveAll(Iterable<AltroAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
