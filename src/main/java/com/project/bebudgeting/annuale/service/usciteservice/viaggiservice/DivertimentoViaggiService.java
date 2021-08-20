package com.project.bebudgeting.annuale.service.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.DivertimentoViaggiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi.DivertimentoViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DivertimentoViaggiService {
    @Autowired
    DivertimentoViaggiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(DivertimentoViaggiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<DivertimentoViaggiEntity> entities) {
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
    public Iterable<DivertimentoViaggiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<DivertimentoViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<DivertimentoViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public DivertimentoViaggiEntity save(DivertimentoViaggiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<DivertimentoViaggiEntity> saveAll(Iterable<DivertimentoViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
