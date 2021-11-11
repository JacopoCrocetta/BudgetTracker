package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.MusicaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    MusicaRepository repository;

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
    public void delete(MusicaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<MusicaEntity> entities) {
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
     * @return Iterable<MusicaEntity>
     */
    // FIND
    public Iterable<MusicaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<MusicaEntity>
     */
    public Iterable<MusicaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<MusicaEntity>
     */
    public Optional<MusicaEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return MusicaEntity
     */
    // SAVE
    public MusicaEntity save(MusicaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<MusicaEntity>
     */
    public Iterable<MusicaEntity> saveAll(Iterable<MusicaEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
