package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.RiparazioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RiparazioniService {
    @Autowired
    RiparazioniRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(RiparazioniEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<RiparazioniEntity> entities) {
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
    public Iterable<RiparazioniEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RiparazioniEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RiparazioniEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RiparazioniEntity save(RiparazioniEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RiparazioniEntity> saveAll(Iterable<RiparazioniEntity> entities) {
        return repository.saveAll(entities);
    }
}
