package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.MiglioramentiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class MiglioramentiService {
    @Autowired
    MiglioramentiRepository repository;

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
    public void delete(MiglioramentiEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<MiglioramentiEntity> entities) {
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
     * @return Iterable<MiglioramentiEntity>
     */
    // FIND
    public Iterable<MiglioramentiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<MiglioramentiEntity>
     */
    public Iterable<MiglioramentiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<MiglioramentiEntity>
     */
    public Optional<MiglioramentiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return MiglioramentiEntity
     */
    // SAVE
    public MiglioramentiEntity save(MiglioramentiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<MiglioramentiEntity>
     */
    public Iterable<MiglioramentiEntity> saveAll(Iterable<MiglioramentiEntity> entities) {
        return repository.saveAll(entities);
    }
}
