package com.project.bebudgeting.mensile.service.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.uscite.TrasportiPrevistiEntity;
import com.project.bebudgeting.mensile.repository.previsti.uscite.TrasportiPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TrasportiPrevistiService {
    @Autowired
    TrasportiPrevistiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(TrasportiPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<TrasportiPrevistiEntity> entities) {
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
    public Iterable<TrasportiPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<TrasportiPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<TrasportiPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public TrasportiPrevistiEntity save(TrasportiPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<TrasportiPrevistiEntity> saveAll(Iterable<TrasportiPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}