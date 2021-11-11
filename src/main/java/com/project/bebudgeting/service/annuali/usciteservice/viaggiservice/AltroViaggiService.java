package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AltroViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.AltroViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroViaggiService {
    @Autowired
    AltroViaggiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltroViaggiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<AltroViaggiEntity> entities) {
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
    public Iterable<AltroViaggiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroViaggiEntity save(AltroViaggiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroViaggiEntity> saveAll(Iterable<AltroViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
