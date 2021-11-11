package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.RegaliDBEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.RegaliDBRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliDBService {
    @Autowired
    RegaliDBRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(RegaliDBEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<RegaliDBEntity> entities) {
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
    public Iterable<RegaliDBEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RegaliDBEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RegaliDBEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RegaliDBEntity save(RegaliDBEntity entity) {
        return repository.save(entity);
    }

    public Iterable<RegaliDBEntity> saveAll(Iterable<RegaliDBEntity> entities) {
        return repository.saveAll(entities);
    }
}
