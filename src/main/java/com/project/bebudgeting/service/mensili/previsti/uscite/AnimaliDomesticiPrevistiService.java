package com.project.bebudgeting.service.mensili.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.uscite.AnimaliDomesticiPrevisteEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.uscite.AnimaliDomesticiPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AnimaliDomesticiPrevistiService {
    @Autowired
    AnimaliDomesticiPrevistiRepository repository;

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
    public void delete(AnimaliDomesticiPrevisteEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<AnimaliDomesticiPrevisteEntity> entities) {
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
     * @return Iterable<AnimaliDomesticiPrevisteEntity>
     */
    // FIND
    public Iterable<AnimaliDomesticiPrevisteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AnimaliDomesticiPrevisteEntity>
     */
    public Iterable<AnimaliDomesticiPrevisteEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AnimaliDomesticiPrevisteEntity>
     */
    public Optional<AnimaliDomesticiPrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AnimaliDomesticiPrevisteEntity
     */
    // SAVE
    public AnimaliDomesticiPrevisteEntity save(AnimaliDomesticiPrevisteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AnimaliDomesticiPrevisteEntity>
     */
    public Iterable<AnimaliDomesticiPrevisteEntity> saveAll(Iterable<AnimaliDomesticiPrevisteEntity> entities) {
        return repository.saveAll(entities);
    }
}
