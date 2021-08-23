package com.project.bebudgeting.mensile.service.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.DebitiEffettiviEntity;
import com.project.bebudgeting.mensile.repository.effettivi.uscite.DebitiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DebitiEffettiviService {
    @Autowired
    DebitiEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(DebitiEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<DebitiEffettiviEntity> entities) {
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
    public Iterable<DebitiEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<DebitiEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<DebitiEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public DebitiEffettiviEntity save(DebitiEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<DebitiEffettiviEntity> saveAll(Iterable<DebitiEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
