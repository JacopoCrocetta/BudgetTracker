package com.project.bebudgeting.annuale.service.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.DivertimentoEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryviaggi.DivertimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DivertimentoService {
    @Autowired
    DivertimentoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(DivertimentoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<DivertimentoEntity> entities) {
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
    public Iterable<DivertimentoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<DivertimentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<DivertimentoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public DivertimentoEntity save(DivertimentoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<DivertimentoEntity> saveAll(Iterable<DivertimentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
