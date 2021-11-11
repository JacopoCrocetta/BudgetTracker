package com.project.bebudgeting.service.mensili.previsti.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.entrate.BonusPrevistiEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.entrate.BonusPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BonusPrevistiService {
    @Autowired
    BonusPrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(BonusPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<BonusPrevistiEntity> entities) {
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
    public Iterable<BonusPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BonusPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BonusPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BonusPrevistiEntity save(BonusPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<BonusPrevistiEntity> saveAll(Iterable<BonusPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
