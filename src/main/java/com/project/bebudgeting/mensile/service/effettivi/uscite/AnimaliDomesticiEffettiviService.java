package com.project.bebudgeting.mensile.service.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.AnimaliDomesticiEffettiviEntity;
import com.project.bebudgeting.mensile.repository.effettivi.uscite.AnimaliDomesticiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AnimaliDomesticiEffettiviService {
    @Autowired
    AnimaliDomesticiEffettiviRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AnimaliDomesticiEffettiviEntity entity) throws NotFoundException {
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

    public void deleteAll(Iterable<AnimaliDomesticiEffettiviEntity> entities) {
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
    public Iterable<AnimaliDomesticiEffettiviEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AnimaliDomesticiEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AnimaliDomesticiEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AnimaliDomesticiEffettiviEntity save(AnimaliDomesticiEffettiviEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AnimaliDomesticiEffettiviEntity> saveAll(Iterable<AnimaliDomesticiEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
