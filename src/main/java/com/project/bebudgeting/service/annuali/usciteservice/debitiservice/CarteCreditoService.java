package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.CarteCreditoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CarteCreditoService {
    @Autowired
    CarteCreditoRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entity
     */
    public void delete(CarteCreditoEntity entity) {
        repository.delete(entity);

    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<CarteCreditoEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    /**
     * @param id
     * @throws NotFoundException
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
     * @return Iterable<CarteCreditoEntity>
     */
    public Iterable<CarteCreditoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<CarteCreditoEntity>
     */
    public Iterable<CarteCreditoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<CarteCreditoEntity>
     */
    public Optional<CarteCreditoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return CarteCreditoEntity
     */
    public CarteCreditoEntity save(CarteCreditoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<CarteCreditoEntity>
     */
    public Iterable<CarteCreditoEntity> saveAll(Iterable<CarteCreditoEntity> entities) {
        return repository.saveAll(entities);
    }
}
