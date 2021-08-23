package com.project.bebudgeting.mensile.service.previsti.entrate;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.entrate.RisparmiPrevistiEntity;
import com.project.bebudgeting.mensile.repository.previsti.entrate.RisparmiPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RisparmiPrevistiService {
    @Autowired
    RisparmiPrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(RisparmiPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<RisparmiPrevistiEntity> entities) {
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
    public Iterable<RisparmiPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RisparmiPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RisparmiPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RisparmiPrevistiEntity save(RisparmiPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RisparmiPrevistiEntity> saveAll(Iterable<RisparmiPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
