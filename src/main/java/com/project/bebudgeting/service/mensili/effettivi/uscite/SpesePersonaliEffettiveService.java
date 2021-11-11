package com.project.bebudgeting.service.mensili.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.SpesePersonaliEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.uscite.SpesePersonaliEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpesePersonaliEffettiveService {
    @Autowired
    SpesePersonaliEffettiveRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    public void delete(SpesePersonaliEffettiviEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SpesePersonaliEffettiviEntity> entities) {
        repository.deleteAll(entities);
    }

    /**
     * @param ids
     */
    public void deleteAllByID(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<SpesePersonaliEffettiviEntity>
     */
    // FIND
    public Iterable<SpesePersonaliEffettiviEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SpesePersonaliEffettiviEntity>
     */
    public Iterable<SpesePersonaliEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SpesePersonaliEffettiviEntity>
     */
    public Optional<SpesePersonaliEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return SpesePersonaliEffettiviEntity
     */
    // SAVE
    public SpesePersonaliEffettiviEntity save(SpesePersonaliEffettiviEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SpesePersonaliEffettiviEntity>
     */
    public Iterable<SpesePersonaliEffettiviEntity> saveAll(Iterable<SpesePersonaliEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
