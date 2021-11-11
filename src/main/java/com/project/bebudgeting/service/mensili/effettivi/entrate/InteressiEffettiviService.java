package com.project.bebudgeting.service.mensili.effettivi.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.InteressiEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.entrate.InteressiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class InteressiEffettiviService {
    @Autowired
    InteressiEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(InteressiEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<InteressiEffettiviEntity> entities) {
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
    public Iterable<InteressiEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<InteressiEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<InteressiEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public InteressiEffettiviEntity save(InteressiEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<InteressiEffettiviEntity> saveAll(Iterable<InteressiEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
