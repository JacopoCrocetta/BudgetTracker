package com.project.bebudgeting.service.mensili.effettivi.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.entrate.BustaPagaEffettiveEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.entrate.BustaPagaEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BustaPagaEffettiveService {
    @Autowired
    BustaPagaEffettiviRepository repository;

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
    public void delete(BustaPagaEffettiveEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<BustaPagaEffettiveEntity> entities) {
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
     * @return Iterable<BustaPagaEffettiveEntity>
     */
    // FIND
    public Iterable<BustaPagaEffettiveEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BustaPagaEffettiveEntity>
     */
    public Iterable<BustaPagaEffettiveEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BustaPagaEffettiveEntity>
     */
    public Optional<BustaPagaEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BustaPagaEffettiveEntity
     */
    // SAVE
    public BustaPagaEffettiveEntity save(BustaPagaEffettiveEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BustaPagaEffettiveEntity>
     */
    public Iterable<BustaPagaEffettiveEntity> saveAll(Iterable<BustaPagaEffettiveEntity> entities) {
        return repository.saveAll(entities);
    }
}
