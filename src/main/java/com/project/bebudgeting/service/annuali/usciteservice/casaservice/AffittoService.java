package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.AffittoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AffittoService {
    @Autowired
    AffittoRepository repository;

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
    public void delete(AffittoEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<AffittoEntity> entities) {
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
     * @return Iterable<AffittoEntity>
     */
    // FIND
    public Iterable<AffittoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AffittoEntity>
     */
    public Iterable<AffittoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AffittoEntity>
     */
    public Optional<AffittoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AffittoEntity
     */
    // SAVE
    public AffittoEntity save(AffittoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AffittoEntity>
     */
    public Iterable<AffittoEntity> saveAll(Iterable<AffittoEntity> entities) {
        return repository.saveAll(entities);
    }
}
