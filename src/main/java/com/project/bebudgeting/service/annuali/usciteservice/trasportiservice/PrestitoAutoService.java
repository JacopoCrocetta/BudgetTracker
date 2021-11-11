package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.PrestitoAutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class PrestitoAutoService {
    @Autowired
    PrestitoAutoRepository repository;

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
    public void delete(PrestitoAutoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<PrestitoAutoEntity> entities) {
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
     * @return Iterable<PrestitoAutoEntity>
     */
    // FIND
    public Iterable<PrestitoAutoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<PrestitoAutoEntity>
     */
    public Iterable<PrestitoAutoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<PrestitoAutoEntity>
     */
    public Optional<PrestitoAutoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return PrestitoAutoEntity
     */
    // SAVE
    public PrestitoAutoEntity save(PrestitoAutoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<PrestitoAutoEntity>
     */
    public Iterable<PrestitoAutoEntity> saveAll(Iterable<PrestitoAutoEntity> entities) {
        return repository.saveAll(entities);
    }
}
