package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.AltroIstruzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroIstruzioneService {
    @Autowired
    AltroIstruzioneRepository repository;

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
    public void delete(AltroIstruzioneEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<AltroIstruzioneEntity> entities) {
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
     * @return Iterable<AltroIstruzioneEntity>
     */
    // FIND
    public Iterable<AltroIstruzioneEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroIstruzioneEntity>
     */
    public Iterable<AltroIstruzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroIstruzioneEntity>
     */
    public Optional<AltroIstruzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltroIstruzioneEntity
     */
    // SAVE
    public AltroIstruzioneEntity save(AltroIstruzioneEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroIstruzioneEntity>
     */
    public Iterable<AltroIstruzioneEntity> saveAll(Iterable<AltroIstruzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
