package com.project.bebudgeting.service.annuali.usciteservice.animalidomesticiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryanimalidomestici.GiocattoliAnimaliDomesticiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class GiocattoliAnimaliDomesticiService {
    @Autowired
    GiocattoliAnimaliDomesticiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(GiocattoliAnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<GiocattoliAnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(giocattoliEntity -> {
            try {
                this.delete(giocattoliEntity);
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
    public Iterable<GiocattoliAnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<GiocattoliAnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<GiocattoliAnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public GiocattoliAnimaliDomesticiEntity save(GiocattoliAnimaliDomesticiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<GiocattoliAnimaliDomesticiEntity> saveAll(Iterable<GiocattoliAnimaliDomesticiEntity> entities) {
        return repository.saveAll(entities);
    }
}
