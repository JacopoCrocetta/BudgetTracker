package com.project.bebudgeting.mensile.service.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.uscite.RegaliPrevistiEntity;
import com.project.bebudgeting.mensile.repository.previsti.uscite.RegaliPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliPrevistiService {
    @Autowired
    RegaliPrevistiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(RegaliPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<RegaliPrevistiEntity> entities) {
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
    public Iterable<RegaliPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RegaliPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RegaliPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RegaliPrevistiEntity save(RegaliPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RegaliPrevistiEntity> saveAll(Iterable<RegaliPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
