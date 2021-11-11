package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.ConcertiOSpettacoliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ConcertiOSpettacoliService {
    @Autowired
    ConcertiOSpettacoliRepository repository;

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
    public void delete(ConcertiOSpettacoliEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<ConcertiOSpettacoliEntity> entities) {
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
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    // FIND
    public Iterable<ConcertiOSpettacoliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    public Iterable<ConcertiOSpettacoliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ConcertiOSpettacoliEntity>
     */
    public Optional<ConcertiOSpettacoliEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ConcertiOSpettacoliEntity
     */
    // SAVE
    public ConcertiOSpettacoliEntity save(ConcertiOSpettacoliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    public Iterable<ConcertiOSpettacoliEntity> saveAll(Iterable<ConcertiOSpettacoliEntity> entities) {
        return repository.saveAll(entities);
    }
}