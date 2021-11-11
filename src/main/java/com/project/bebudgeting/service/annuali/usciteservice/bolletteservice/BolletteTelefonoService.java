package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTelefonoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteTelefonoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteTelefonoService {
    @Autowired
    BolletteTelefonoRepository repository;

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
    public void delete(BolletteTelefonoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteTelefonoEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
     * @return Iterable<BolletteTelefonoEntity>
     */
    // FIND
    public Iterable<BolletteTelefonoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteTelefonoEntity>
     */
    public Iterable<BolletteTelefonoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteTelefonoEntity>
     */
    public Optional<BolletteTelefonoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BolletteTelefonoEntity
     */
    // SAVE
    public BolletteTelefonoEntity save(BolletteTelefonoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteTelefonoEntity>
     */
    public Iterable<BolletteTelefonoEntity> saveAll(Iterable<BolletteTelefonoEntity> entities) {
        return repository.saveAll(entities);
    }
}
