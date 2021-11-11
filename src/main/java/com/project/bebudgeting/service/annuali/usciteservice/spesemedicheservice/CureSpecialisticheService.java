package com.project.bebudgeting.service.annuali.usciteservice.spesemedicheservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.CureSpecialisticheEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesemediche.CureSpecialisticheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CureSpecialisticheService {
    @Autowired
    CureSpecialisticheRepository repository;

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
    public void delete(CureSpecialisticheEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<CureSpecialisticheEntity> entities) {
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
            throw new NotFoundException("Item not found");
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
     * @return Iterable<CureSpecialisticheEntity>
     */
    // FIND
    public Iterable<CureSpecialisticheEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<CureSpecialisticheEntity>
     */
    public Iterable<CureSpecialisticheEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<CureSpecialisticheEntity>
     */
    public Optional<CureSpecialisticheEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return CureSpecialisticheEntity
     */
    // SAVE
    public CureSpecialisticheEntity save(CureSpecialisticheEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<CureSpecialisticheEntity>
     */
    public Iterable<CureSpecialisticheEntity> saveAll(Iterable<CureSpecialisticheEntity> entities) {
        return repository.saveAll(entities);
    }
}
