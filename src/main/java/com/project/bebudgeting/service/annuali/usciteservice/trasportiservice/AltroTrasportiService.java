package com.project.bebudgeting.service.annuali.usciteservice.trasportiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.AltroTrasportiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytrasporti.AltroTrasportiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroTrasportiService {
    @Autowired
    AltroTrasportiRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltroTrasportiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<AltroTrasportiEntity> entities) {
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
    public Iterable<AltroTrasportiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroTrasportiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroTrasportiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroTrasportiEntity save(AltroTrasportiEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroTrasportiEntity> saveAll(Iterable<AltroTrasportiEntity> entities) {
        return repository.saveAll(entities);
    }
}
