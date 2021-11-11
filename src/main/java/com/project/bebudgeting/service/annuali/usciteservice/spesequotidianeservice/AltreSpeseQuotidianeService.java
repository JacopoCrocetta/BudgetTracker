package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AltroSpeseQuotidianeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.AltroSpeseQuotidianeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreSpeseQuotidianeService {
    @Autowired
    AltroSpeseQuotidianeRepository repository;

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
    public void delete(AltroSpeseQuotidianeEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroSpeseQuotidianeEntity> entities) {
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
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    // FIND
    public Iterable<AltroSpeseQuotidianeEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    public Iterable<AltroSpeseQuotidianeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroSpeseQuotidianeEntity>
     */
    public Optional<AltroSpeseQuotidianeEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltroSpeseQuotidianeEntity
     */
    // SAVE
    public AltroSpeseQuotidianeEntity save(AltroSpeseQuotidianeEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroSpeseQuotidianeEntity>
     */
    public Iterable<AltroSpeseQuotidianeEntity> saveAll(Iterable<AltroSpeseQuotidianeEntity> entities) {
        return repository.saveAll(entities);
    }
}
