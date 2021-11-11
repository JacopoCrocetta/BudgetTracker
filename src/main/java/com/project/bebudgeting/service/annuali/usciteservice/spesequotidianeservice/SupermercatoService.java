package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.SupermercatoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.SupermercatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SupermercatoService {
    @Autowired
    SupermercatoRepository repository;

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
    public void delete(SupermercatoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<SupermercatoEntity> entities) {
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
     * @return Iterable<SupermercatoEntity>
     */
    // FIND
    public Iterable<SupermercatoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<SupermercatoEntity>
     */
    public Iterable<SupermercatoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<SupermercatoEntity>
     */
    public Optional<SupermercatoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return SupermercatoEntity
     */
    // SAVE
    public SupermercatoEntity save(SupermercatoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<SupermercatoEntity>
     */
    public Iterable<SupermercatoEntity> saveAll(Iterable<SupermercatoEntity> entities) {
        return repository.saveAll(entities);
    }
}
