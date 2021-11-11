package com.project.bebudgeting.service.mensili.previsti.entrate;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.entrate.BustaPagaPrevisteEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.entrate.BustaPagaPrevisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BustaPagaPrevisteService {
    @Autowired
    BustaPagaPrevisteRepository repository;

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
    public void delete(BustaPagaPrevisteEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<BustaPagaPrevisteEntity> entities) {
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
     * @return Iterable<BustaPagaPrevisteEntity>
     */
    // FIND
    public Iterable<BustaPagaPrevisteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BustaPagaPrevisteEntity>
     */
    public Iterable<BustaPagaPrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BustaPagaPrevisteEntity>
     */
    public Optional<BustaPagaPrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BustaPagaPrevisteEntity
     */
    // SAVE
    public BustaPagaPrevisteEntity save(BustaPagaPrevisteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BustaPagaPrevisteEntity>
     */
    public Iterable<BustaPagaPrevisteEntity> saveAll(Iterable<BustaPagaPrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}
