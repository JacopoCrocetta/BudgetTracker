package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.VestitiFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.VestitiFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class VestitiFigliService {
    @Autowired
    VestitiFigliRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(VestitiFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<VestitiFigliEntity> entities) {
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
    public Iterable<VestitiFigliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<VestitiFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<VestitiFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public VestitiFigliEntity save(VestitiFigliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<VestitiFigliEntity> saveAll(Iterable<VestitiFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
