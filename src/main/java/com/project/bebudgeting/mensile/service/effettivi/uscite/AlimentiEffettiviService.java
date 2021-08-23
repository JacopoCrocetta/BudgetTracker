package com.project.bebudgeting.mensile.service.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.AlimentiEffettiviEntity;
import com.project.bebudgeting.mensile.repository.effettivi.uscite.AlimentiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AlimentiEffettiviService {
    @Autowired
    AlimentiEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AlimentiEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<AlimentiEffettiviEntity> entities) {
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
    public Iterable<AlimentiEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AlimentiEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AlimentiEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AlimentiEffettiviEntity save(AlimentiEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AlimentiEffettiviEntity> saveAll(Iterable<AlimentiEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
