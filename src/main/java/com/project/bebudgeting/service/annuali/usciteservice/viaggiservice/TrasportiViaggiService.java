package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.TrasportiViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.TrasportiViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TrasportiViaggiService {
    @Autowired
    TrasportiViaggiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(TrasportiViaggiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<TrasportiViaggiEntity> entities) {
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
    public Iterable<TrasportiViaggiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<TrasportiViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<TrasportiViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public TrasportiViaggiEntity save(TrasportiViaggiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<TrasportiViaggiEntity> saveAll(Iterable<TrasportiViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
