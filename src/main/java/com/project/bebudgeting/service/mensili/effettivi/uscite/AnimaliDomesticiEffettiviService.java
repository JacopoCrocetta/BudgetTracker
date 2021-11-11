package com.project.bebudgeting.service.mensili.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.AnimaliDomesticiEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.uscite.AnimaliDomesticiEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AnimaliDomesticiEffettiviService {
    @Autowired
    AnimaliDomesticiEffettiviRepository repository;

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
    public void delete(AnimaliDomesticiEffettiviEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<AnimaliDomesticiEffettiviEntity> entities) {
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
     * @return Iterable<AnimaliDomesticiEffettiviEntity>
     */
    // FIND
    public Iterable<AnimaliDomesticiEffettiviEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AnimaliDomesticiEffettiviEntity>
     */
    public Iterable<AnimaliDomesticiEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AnimaliDomesticiEffettiviEntity>
     */
    public Optional<AnimaliDomesticiEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AnimaliDomesticiEffettiviEntity
     */
    // SAVE
    public AnimaliDomesticiEffettiviEntity save(AnimaliDomesticiEffettiviEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AnimaliDomesticiEffettiviEntity>
     */
    public Iterable<AnimaliDomesticiEffettiviEntity> saveAll(Iterable<AnimaliDomesticiEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
