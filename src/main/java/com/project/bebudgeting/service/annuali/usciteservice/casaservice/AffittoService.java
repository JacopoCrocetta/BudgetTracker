package com.project.bebudgeting.service.annuali.usciteservice.casaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorycasa.AffittoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AffittoService {
    @Autowired
    AffittoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AffittoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AffittoEntity> entities) {
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
    public Iterable<AffittoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AffittoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AffittoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AffittoEntity save(AffittoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AffittoEntity> saveAll(Iterable<AffittoEntity> entities) {
        return repository.saveAll(entities);
    }
}
