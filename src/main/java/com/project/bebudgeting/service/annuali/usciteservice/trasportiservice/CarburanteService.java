package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.CarburanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarburanteService {
    @Autowired
    CarburanteRepository repository;

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
    public void delete(CarburanteEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<CarburanteEntity> entities) {
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
     * @return Iterable<CarburanteEntity>
     */
    public Iterable<CarburanteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<CarburanteEntity>
     */
    public Iterable<CarburanteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<CarburanteEntity>
     */
    public Optional<CarburanteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return CarburanteEntity
     */
    public CarburanteEntity save(CarburanteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<CarburanteEntity>
     */
    public Iterable<CarburanteEntity> saveAll(Iterable<CarburanteEntity> entities) {
        return repository.saveAll(entities);
    }
}
