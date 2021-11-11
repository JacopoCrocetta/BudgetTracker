package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.ArredamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ArredamentoService {
    @Autowired
    ArredamentoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(ArredamentoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<ArredamentoEntity> entities) {
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
            throw new NotFoundException("Item not Found");
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
    public Iterable<ArredamentoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<ArredamentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<ArredamentoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public ArredamentoEntity save(ArredamentoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<ArredamentoEntity> saveAll(Iterable<ArredamentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
