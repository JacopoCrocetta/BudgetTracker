package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteTVEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteTVRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteTVService {
    @Autowired
    BolletteTVRepository repository;

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
    public void delete(BolletteTVEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteTVEntity> entities) {
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
     * @return Iterable<BolletteTVEntity>
     */
    // FIND
    public Iterable<BolletteTVEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteTVEntity>
     */
    public Iterable<BolletteTVEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteTVEntity>
     */
    public Optional<BolletteTVEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BolletteTVEntity
     */
    // SAVE
    public BolletteTVEntity save(BolletteTVEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteTVEntity>
     */
    public Iterable<BolletteTVEntity> saveAll(Iterable<BolletteTVEntity> entities) {
        return repository.saveAll(entities);
    }
}
