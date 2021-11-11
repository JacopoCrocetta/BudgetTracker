package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.SpeseMedicheFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseMedicheFigliService {
    @Autowired
    SpeseMedicheFigliRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(SpeseMedicheFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SpeseMedicheFigliEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not Found");
        }
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<SpeseMedicheFigliEntity>
     */
    // FIND
    public Iterable<SpeseMedicheFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SpeseMedicheFigliEntity>
     */
    public Iterable<SpeseMedicheFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SpeseMedicheFigliEntity>
     */
    public Optional<SpeseMedicheFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return SpeseMedicheFigliEntity
     */
    // SAVE
    public SpeseMedicheFigliEntity save(SpeseMedicheFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SpeseMedicheFigliEntity>
     */
    public Iterable<SpeseMedicheFigliEntity> saveAll(Iterable<SpeseMedicheFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
