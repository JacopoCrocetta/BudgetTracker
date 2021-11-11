package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.BigliettiAereiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BigliettiAereiService {
    @Autowired
    BigliettiAereiRepository repository;

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
    public void delete(BigliettiAereiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BigliettiAereiEntity> entities) {
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
     * @return Iterable<BigliettiAereiEntity>
     */
    // FIND
    public Iterable<BigliettiAereiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BigliettiAereiEntity>
     */
    public Iterable<BigliettiAereiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BigliettiAereiEntity>
     */
    public Optional<BigliettiAereiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return BigliettiAereiEntity
     */
    // SAVE
    public BigliettiAereiEntity save(BigliettiAereiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BigliettiAereiEntity>
     */
    public Iterable<BigliettiAereiEntity> saveAll(Iterable<BigliettiAereiEntity> entities) {
        return repository.saveAll(entities);
    }
}
