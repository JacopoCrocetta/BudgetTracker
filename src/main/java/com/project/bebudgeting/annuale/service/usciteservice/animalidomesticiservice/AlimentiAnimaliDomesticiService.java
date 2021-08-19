package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.AlimentiAnimaliDomesticiRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlimentiAnimaliDomesticiService {
    @Autowired
    AlimentiAnimaliDomesticiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AlimentiAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AlimentiAnimaliDomesticiEntity> entitiesToDelete) {
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
    public Iterable<AlimentiAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AlimentiAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AlimentiAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AlimentiAnimaliDomesticiEntity save(AlimentiAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AlimentiAnimaliDomesticiEntity> saveAll(Iterable<AlimentiAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
