package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.AltreBolletteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.AltreBolletteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltreBolletteService {
    @Autowired
    AltreBolletteRepository repository;

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
    public void delete(AltreBolletteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltreBolletteEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
     * @return Iterable<AltreBolletteEntity>
     */
    // FIND
    public Iterable<AltreBolletteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltreBolletteEntity>
     */
    public Iterable<AltreBolletteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltreBolletteEntity>
     */
    public Optional<AltreBolletteEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltreBolletteEntity
     */
    // SAVE
    public AltreBolletteEntity save(AltreBolletteEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltreBolletteEntity>
     */
    public Iterable<AltreBolletteEntity> saveAll(Iterable<AltreBolletteEntity> entities) {
        return repository.saveAll(entities);
    }
}
