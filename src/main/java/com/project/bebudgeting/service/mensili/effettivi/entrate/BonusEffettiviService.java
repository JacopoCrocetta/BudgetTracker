package com.project.bebudgeting.service.mensili.effettivi.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.BonusEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.entrate.BonusEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BonusEffettiviService {
    @Autowired
    BonusEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BonusEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<BonusEffettiviEntity> entities) {
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
    public Iterable<BonusEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BonusEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BonusEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BonusEffettiviEntity save(BonusEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BonusEffettiviEntity> saveAll(Iterable<BonusEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
