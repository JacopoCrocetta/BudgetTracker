package com.project.bebudgeting.service.mensili.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.uscite.AlimentiPrevistiEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.uscite.AlimentiPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AlimentiPrevistiService {
    @Autowired
    AlimentiPrevistiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AlimentiPrevistiEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<AlimentiPrevistiEntity> entities) {
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
    public Iterable<AlimentiPrevistiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AlimentiPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AlimentiPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AlimentiPrevistiEntity save(AlimentiPrevistiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AlimentiPrevistiEntity> saveAll(Iterable<AlimentiPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
