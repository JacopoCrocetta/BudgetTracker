package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.LezioniIndipendentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class LezioniIndipendentiService {
    @Autowired
    LezioniIndipendentiRepository repository;

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
    public void delete(LezioniIndipendentiEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<LezioniIndipendentiEntity> entities) {
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
     * @return Iterable<LezioniIndipendentiEntity>
     */
    // FIND
    public Iterable<LezioniIndipendentiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LezioniIndipendentiEntity>
     */
    public Iterable<LezioniIndipendentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LezioniIndipendentiEntity>
     */
    public Optional<LezioniIndipendentiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return LezioniIndipendentiEntity
     */
    // SAVE
    public LezioniIndipendentiEntity save(LezioniIndipendentiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LezioniIndipendentiEntity>
     */
    public Iterable<LezioniIndipendentiEntity> saveAll(Iterable<LezioniIndipendentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
