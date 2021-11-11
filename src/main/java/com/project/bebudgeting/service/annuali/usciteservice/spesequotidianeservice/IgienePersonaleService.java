package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.IgienePersonaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class IgienePersonaleService {
    @Autowired
    IgienePersonaleRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(IgienePersonaleEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<IgienePersonaleEntity> entities) {
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
    public Iterable<IgienePersonaleEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<IgienePersonaleEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<IgienePersonaleEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public IgienePersonaleEntity save(IgienePersonaleEntity entity) {
        return repository.save(entity);
    }

    public Iterable<IgienePersonaleEntity> saveAll(Iterable<IgienePersonaleEntity> entities) {
        return repository.saveAll(entities);
    }
}
