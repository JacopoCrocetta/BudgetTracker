package com.project.bebudgeting.mensile.service.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.uscite.SpesePersonaliPrevistiEntity;
import com.project.bebudgeting.mensile.repository.previsti.uscite.SpesePersonaliPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpesePersonaliPrevisteService {
    @Autowired
    SpesePersonaliPrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(SpesePersonaliPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<SpesePersonaliPrevistiEntity> entities) {
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
    public Iterable<SpesePersonaliPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SpesePersonaliPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SpesePersonaliPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SpesePersonaliPrevistiEntity save(SpesePersonaliPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SpesePersonaliPrevistiEntity> saveAll(Iterable<SpesePersonaliPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
