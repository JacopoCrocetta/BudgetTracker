package com.project.bebudgeting.service.mensili.previsti.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.entrate.InteressiPrevistiEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.entrate.InteressiPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class InteressiPrevistiService {
    @Autowired
    InteressiPrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(InteressiPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<InteressiPrevistiEntity> entities) {
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
    public Iterable<InteressiPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<InteressiPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<InteressiPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public InteressiPrevistiEntity save(InteressiPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<InteressiPrevistiEntity> saveAll(Iterable<InteressiPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
