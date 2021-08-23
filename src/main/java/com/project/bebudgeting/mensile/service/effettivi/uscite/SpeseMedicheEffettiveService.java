package com.project.bebudgeting.mensile.service.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.SpeseMedicheEffettiviEntity;
import com.project.bebudgeting.mensile.repository.effettivi.uscite.SpeseMedicheEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseMedicheEffettiveService {
    @Autowired
    SpeseMedicheEffettiveRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(SpeseMedicheEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<SpeseMedicheEffettiviEntity> entities) {
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
    public Iterable<SpeseMedicheEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SpeseMedicheEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SpeseMedicheEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SpeseMedicheEffettiviEntity save(SpeseMedicheEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SpeseMedicheEffettiviEntity> saveAll(Iterable<SpeseMedicheEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
