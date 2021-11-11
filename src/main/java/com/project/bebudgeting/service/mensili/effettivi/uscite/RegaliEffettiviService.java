package com.project.bebudgeting.service.mensili.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.RegaliEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.uscite.RegaliEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliEffettiviService {
    @Autowired
    RegaliEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(RegaliEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<RegaliEffettiviEntity> entities) {
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
    public Iterable<RegaliEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RegaliEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RegaliEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RegaliEffettiviEntity save(RegaliEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RegaliEffettiviEntity> saveAll(Iterable<RegaliEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
