package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.RiparazioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RiparazioniService {
    @Autowired
    RiparazioniRepository repository;

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
    public void delete(RiparazioniEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<RiparazioniEntity> entities) {
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
     * @return Iterable<RiparazioniEntity>
     */
    // FIND
    public Iterable<RiparazioniEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RiparazioniEntity>
     */
    public Iterable<RiparazioniEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RiparazioniEntity>
     */
    public Optional<RiparazioniEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return RiparazioniEntity
     */
    // SAVE
    public RiparazioniEntity save(RiparazioniEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RiparazioniEntity>
     */
    public Iterable<RiparazioniEntity> saveAll(Iterable<RiparazioniEntity> entities) {
        return repository.saveAll(entities);
    }
}
