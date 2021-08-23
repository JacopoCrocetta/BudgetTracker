package com.project.bebudgeting.mensile.service.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.uscite.CasaPrevisteEntity;
import com.project.bebudgeting.mensile.repository.previsti.uscite.CasaPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CasaPrevisteService {
    @Autowired
    CasaPrevistiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(CasaPrevisteEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<CasaPrevisteEntity> entities) {
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
    public Iterable<CasaPrevisteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<CasaPrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<CasaPrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public CasaPrevisteEntity save(CasaPrevisteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<CasaPrevisteEntity> saveAll(Iterable<CasaPrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}
