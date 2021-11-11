package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.ManutenzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ManutenzioneService {
    @Autowired
    ManutenzioneRepository repository;

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
    public void delete(ManutenzioneEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<ManutenzioneEntity> entities) {
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
     * @return Iterable<ManutenzioneEntity>
     */
    // FIND
    public Iterable<ManutenzioneEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ManutenzioneEntity>
     */
    public Iterable<ManutenzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ManutenzioneEntity>
     */
    public Optional<ManutenzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ManutenzioneEntity
     */
    // SAVE
    public ManutenzioneEntity save(ManutenzioneEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ManutenzioneEntity>
     */
    public Iterable<ManutenzioneEntity> saveAll(Iterable<ManutenzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
