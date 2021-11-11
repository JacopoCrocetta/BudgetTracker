package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.SoftwareEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.SoftwareRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SoftwareService {
    @Autowired
    SoftwareRepository repository;

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
    public void delete(SoftwareEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SoftwareEntity> entities) {
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
     * @return Iterable<SoftwareEntity>
     */
    // FIND
    public Iterable<SoftwareEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SoftwareEntity>
     */
    public Iterable<SoftwareEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SoftwareEntity>
     */
    public Optional<SoftwareEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return SoftwareEntity
     */
    // SAVE
    public SoftwareEntity save(SoftwareEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SoftwareEntity>
     */
    public Iterable<SoftwareEntity> saveAll(Iterable<SoftwareEntity> entities) {
        return repository.saveAll(entities);
    }
}
