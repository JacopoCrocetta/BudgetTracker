package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.TrasportoPubblicoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.TrasportoPubblicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrasportoPubblicoService {
    @Autowired
    TrasportoPubblicoRepository repository;

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
     */
    public void delete(TrasportoPubblicoEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<TrasportoPubblicoEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            this.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<TrasportoPubblicoEntity>
     */
    public Iterable<TrasportoPubblicoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TrasportoPubblicoEntity>
     */
    public Iterable<TrasportoPubblicoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TrasportoPubblicoEntity>
     */
    public Optional<TrasportoPubblicoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return TrasportoPubblicoEntity
     */
    public TrasportoPubblicoEntity save(TrasportoPubblicoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TrasportoPubblicoEntity>
     */
    public Iterable<TrasportoPubblicoEntity> saveAll(Iterable<TrasportoPubblicoEntity> entities) {
        return repository.saveAll(entities);
    }
}
