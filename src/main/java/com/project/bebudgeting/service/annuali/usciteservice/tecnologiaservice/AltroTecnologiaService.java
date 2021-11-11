package com.project.bebudgeting.service.annuali.usciteservice.tecnologiaservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotecnologia.AltroTecnologiaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorytecnologia.AltroTecnologiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroTecnologiaService {
    @Autowired
    AltroTecnologiaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(AltroTecnologiaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<AltroTecnologiaEntity> entities) {
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
    public Iterable<AltroTecnologiaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroTecnologiaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroTecnologiaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroTecnologiaEntity save(AltroTecnologiaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroTecnologiaEntity> saveAll(Iterable<AltroTecnologiaEntity> entities) {
        return repository.saveAll(entities);
    }
}
