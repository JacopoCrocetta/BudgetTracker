package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.VestitiSpeseQuotidianeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class VestitiService {
    @Autowired
    VestitiSpeseQuotidianeRepository repository;

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
    public void delete(VestitiSpeseQuotidianeEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<VestitiSpeseQuotidianeEntity> entities) {
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
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    // FIND
    public Iterable<VestitiSpeseQuotidianeEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    public Iterable<VestitiSpeseQuotidianeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<VestitiSpeseQuotidianeEntity>
     */
    public Optional<VestitiSpeseQuotidianeEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return VestitiSpeseQuotidianeEntity
     */
    // SAVE
    public VestitiSpeseQuotidianeEntity save(VestitiSpeseQuotidianeEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<VestitiSpeseQuotidianeEntity>
     */
    public Iterable<VestitiSpeseQuotidianeEntity> saveAll(Iterable<VestitiSpeseQuotidianeEntity> entities) {
        return repository.saveAll(entities);
    }
}
