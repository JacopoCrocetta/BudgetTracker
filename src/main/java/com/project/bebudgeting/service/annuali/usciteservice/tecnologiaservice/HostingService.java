package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.HostingEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.HostingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class HostingService {
    @Autowired
    HostingRepository repository;

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
    public void delete(HostingEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<HostingEntity> entities) {
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
     * @return Iterable<HostingEntity>
     */
    // FIND
    public Iterable<HostingEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<HostingEntity>
     */
    public Iterable<HostingEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<HostingEntity>
     */
    public Optional<HostingEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return HostingEntity
     */
    // SAVE
    public HostingEntity save(HostingEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<HostingEntity>
     */
    public Iterable<HostingEntity> saveAll(Iterable<HostingEntity> entities) {
        return repository.saveAll(entities);
    }
}
