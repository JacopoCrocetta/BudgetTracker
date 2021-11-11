package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.TraslocoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.TraslocoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TraslocoService {
    @Autowired
    TraslocoRepository repository;

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
    public void delete(TraslocoEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<TraslocoEntity> entities) {
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
     * @return Iterable<TraslocoEntity>
     */
    // FIND
    public Iterable<TraslocoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TraslocoEntity>
     */
    public Iterable<TraslocoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TraslocoEntity>
     */
    public Optional<TraslocoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return TraslocoEntity
     */
    // SAVE
    public TraslocoEntity save(TraslocoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TraslocoEntity>
     */
    public Iterable<TraslocoEntity> saveAll(Iterable<TraslocoEntity> entities) {
        return repository.saveAll(entities);
    }
}
