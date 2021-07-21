package com.project.bebudgeting.annuale.service.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.GiocattoliEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryfigli.GiocattoliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class GiocattoliFigliService {
    @Autowired
    GiocattoliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(GiocattoliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<GiocattoliEntity> entities) {
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
    public Iterable<GiocattoliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<GiocattoliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<GiocattoliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public GiocattoliEntity save(GiocattoliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<GiocattoliEntity> saveAll(Iterable<GiocattoliEntity> entities) {
        return repository.saveAll(entities);
    }
}
