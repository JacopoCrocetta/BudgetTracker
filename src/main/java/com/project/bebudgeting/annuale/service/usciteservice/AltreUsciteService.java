package com.project.bebudgeting.annuale.service.usciteservice;

import com.project.bebudgeting.annuale.entity.uscite.AltreUsciteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.AltreUsciteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreUsciteService {
    @Autowired
    AltreUsciteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltreUsciteEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltreUsciteEntity> entitiesToDelete) {
        repository.deleteAll(entitiesToDelete);
    }

    public void deleteAllById(Iterable<Integer> ids) {
    }

    public void deleteById() {
    }
}
