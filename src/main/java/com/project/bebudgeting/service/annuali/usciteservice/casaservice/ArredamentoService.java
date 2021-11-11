package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.ArredamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ArredamentoService {
    @Autowired
    ArredamentoRepository repository;

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
    public void delete(ArredamentoEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<ArredamentoEntity> entities) {
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
     * @return Iterable<ArredamentoEntity>
     */
    // FIND
    public Iterable<ArredamentoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ArredamentoEntity>
     */
    public Iterable<ArredamentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ArredamentoEntity>
     */
    public Optional<ArredamentoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ArredamentoEntity
     */
    // SAVE
    public ArredamentoEntity save(ArredamentoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ArredamentoEntity>
     */
    public Iterable<ArredamentoEntity> saveAll(Iterable<ArredamentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
