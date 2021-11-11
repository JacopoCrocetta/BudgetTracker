package com.project.bebudgeting.service.mensili.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.SpeseMedicheEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.uscite.SpeseMedicheEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseMedicheEffettiveService {
    @Autowired
    SpeseMedicheEffettiveRepository repository;

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
    public void delete(SpeseMedicheEffettiviEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<SpeseMedicheEffettiviEntity> entities) {
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
     * @return Iterable<SpeseMedicheEffettiviEntity>
     */
    // FIND
    public Iterable<SpeseMedicheEffettiviEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SpeseMedicheEffettiviEntity>
     */
    public Iterable<SpeseMedicheEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SpeseMedicheEffettiviEntity>
     */
    public Optional<SpeseMedicheEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return SpeseMedicheEffettiviEntity
     */
    // SAVE
    public SpeseMedicheEffettiviEntity save(SpeseMedicheEffettiviEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SpeseMedicheEffettiviEntity>
     */
    public Iterable<SpeseMedicheEffettiviEntity> saveAll(Iterable<SpeseMedicheEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
