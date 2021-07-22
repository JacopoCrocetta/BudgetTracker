package com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.ServiziOnlineEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorytecnologia.ServiziOnlineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ServiziOnlineService {
    @Autowired
    ServiziOnlineRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(ServiziOnlineEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<ServiziOnlineEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<ServiziOnlineEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<ServiziOnlineEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<ServiziOnlineEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public ServiziOnlineEntity save(ServiziOnlineEntity entity) {
        return repository.save(entity);
    }

    public Iterable<ServiziOnlineEntity> saveAll(Iterable<ServiziOnlineEntity> entities) {
        return repository.saveAll(entities);
    }
}
