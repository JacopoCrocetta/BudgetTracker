package com.project.bebudgeting.service.mensili.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.AltreUsciteEffettiveEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.uscite.AltreUsciteEffettiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreUsciteEffettiviService {
    @Autowired
    AltreUsciteEffettiveRepository repository;

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
    public void delete(AltreUsciteEffettiveEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<AltreUsciteEffettiveEntity> entities) {
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
     * @return Iterable<AltreUsciteEffettiveEntity>
     */
    // FIND
    public Iterable<AltreUsciteEffettiveEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltreUsciteEffettiveEntity>
     */
    public Iterable<AltreUsciteEffettiveEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltreUsciteEffettiveEntity>
     */
    public Optional<AltreUsciteEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltreUsciteEffettiveEntity
     */
    // SAVE
    public AltreUsciteEffettiveEntity save(AltreUsciteEffettiveEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltreUsciteEffettiveEntity>
     */
    public Iterable<AltreUsciteEffettiveEntity> saveAll(Iterable<AltreUsciteEffettiveEntity> entities) {
        return repository.saveAll(entities);
    }
}
