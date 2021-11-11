package com.project.bebudgeting.service.annuali.usciteservice.istruzioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioistruzione.LibriIstruzioneEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryistruzione.LibriIstruzioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class LibriIstruzioneService {
    @Autowired
    LibriIstruzioneRepository repository;

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
    public void delete(LibriIstruzioneEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<LibriIstruzioneEntity> entities) {
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
     * @return Iterable<LibriIstruzioneEntity>
     */
    // FIND
    public Iterable<LibriIstruzioneEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LibriIstruzioneEntity>
     */
    public Iterable<LibriIstruzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LibriIstruzioneEntity>
     */
    public Optional<LibriIstruzioneEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return LibriIstruzioneEntity
     */
    // SAVE
    public LibriIstruzioneEntity save(LibriIstruzioneEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LibriIstruzioneEntity>
     */
    public Iterable<LibriIstruzioneEntity> saveAll(Iterable<LibriIstruzioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
