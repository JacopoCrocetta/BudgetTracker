package com.project.bebudgeting.service.mensili.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.uscite.SpeseMedichePrevistiEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.uscite.SpeseMedichePrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseMedichePrevisteService {
    @Autowired
    SpeseMedichePrevisteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(SpeseMedichePrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<SpeseMedichePrevistiEntity> entities) {
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
    public Iterable<SpeseMedichePrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SpeseMedichePrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SpeseMedichePrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SpeseMedichePrevistiEntity save(SpeseMedichePrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SpeseMedichePrevistiEntity> saveAll(Iterable<SpeseMedichePrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
