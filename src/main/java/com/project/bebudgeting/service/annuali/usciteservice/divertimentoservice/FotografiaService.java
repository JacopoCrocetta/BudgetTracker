package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.FotografiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FotografiaService {
    @Autowired
    FotografiaRepository repository;

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
    public void delete(FotografiaEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<FotografiaEntity> entities) {
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
     * @return Iterable<FotografiaEntity>
     */
    // FIND
    public Iterable<FotografiaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<FotografiaEntity>
     */
    public Iterable<FotografiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<FotografiaEntity>
     */
    public Optional<FotografiaEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return FotografiaEntity
     */
    // SAVE
    public FotografiaEntity save(FotografiaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<FotografiaEntity>
     */
    public Iterable<FotografiaEntity> saveAll(Iterable<FotografiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
