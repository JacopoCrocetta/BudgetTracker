package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.CarburanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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
     * @throws NotFoundException
     */
    public void delete(CarburanteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<CarburanteEntity> entities) {
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
     * @return Iterable<CarburanteEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return CarburanteEntity
     */
    // SAVE
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
