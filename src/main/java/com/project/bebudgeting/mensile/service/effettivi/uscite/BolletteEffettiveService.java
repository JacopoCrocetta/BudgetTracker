package com.project.bebudgeting.mensile.service.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.BolletteEffettiviEntity;
import com.project.bebudgeting.mensile.repository.effettivi.uscite.BolletteEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteEffettiveService {
    @Autowired
    BolletteEffettiveRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BolletteEffettiviEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<BolletteEffettiviEntity> entities) {
        repository.deleteAll(entities);
    }

    public void deleteAllByID(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<BolletteEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteEffettiviEntity save(BolletteEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BolletteEffettiviEntity> saveAll(Iterable<BolletteEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}