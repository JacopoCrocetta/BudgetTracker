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

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(CarteCreditoEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<CarteCreditoEntity> entities) {
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
     * @return Iterable<CarteCreditoEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return CarteCreditoEntity
     */
    // SAVE
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
