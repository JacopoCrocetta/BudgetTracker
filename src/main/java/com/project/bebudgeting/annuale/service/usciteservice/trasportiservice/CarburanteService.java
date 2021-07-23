package com.project.bebudgeting.annuale.service.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorytrasporti.CarburanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CarburanteService {
    @Autowired
    CarburanteRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(CarburanteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<CarburanteEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<CarburanteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<CarburanteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<CarburanteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public CarburanteEntity save(CarburanteEntity entity) {
        return repository.save(entity);
    }

    public Iterable<CarburanteEntity> saveAll(Iterable<CarburanteEntity> entities) {
        return repository.saveAll(entities);
    }
}
