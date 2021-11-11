package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AltroSpeseQuotidianeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.AltroSpeseQuotidianeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreSpeseQuotidianeService {
    @Autowired
    AltroSpeseQuotidianeRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltroSpeseQuotidianeEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<AltroSpeseQuotidianeEntity> entities) {
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
    public Iterable<AltroSpeseQuotidianeEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroSpeseQuotidianeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroSpeseQuotidianeEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroSpeseQuotidianeEntity save(AltroSpeseQuotidianeEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroSpeseQuotidianeEntity> saveAll(Iterable<AltroSpeseQuotidianeEntity> entities) {
        return repository.saveAll(entities);
    }
}
