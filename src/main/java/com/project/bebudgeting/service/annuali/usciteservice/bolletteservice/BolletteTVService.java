package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTVEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteTVRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteTVService {
    @Autowired
    BolletteTVRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteTVEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<BolletteTVEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
    public Iterable<BolletteTVEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteTVEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteTVEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteTVEntity save(BolletteTVEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteTVEntity> saveAll(Iterable<BolletteTVEntity> entities) {
        return repository.saveAll(entities);
    }
}
