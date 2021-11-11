package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.ServiziOnlineEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.ServiziOnlineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ServiziOnlineService {
    @Autowired
    ServiziOnlineRepository repository;

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
    public void delete(ServiziOnlineEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<ServiziOnlineEntity> entities) {
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
     * @return Iterable<ServiziOnlineEntity>
     */
    // FIND
    public Iterable<ServiziOnlineEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ServiziOnlineEntity>
     */
    public Iterable<ServiziOnlineEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ServiziOnlineEntity>
     */
    public Optional<ServiziOnlineEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ServiziOnlineEntity
     */
    // SAVE
    public ServiziOnlineEntity save(ServiziOnlineEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ServiziOnlineEntity>
     */
    public Iterable<ServiziOnlineEntity> saveAll(Iterable<ServiziOnlineEntity> entities) {
        return repository.saveAll(entities);
    }
}
