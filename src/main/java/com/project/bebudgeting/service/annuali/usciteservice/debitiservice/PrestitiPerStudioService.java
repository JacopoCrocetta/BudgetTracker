package com.project.bebudgeting.service.annuali.usciteservice.debitiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.PrestitiPerStudiareEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydebiti.PrestitiPerStudioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class PrestitiPerStudioService {
    @Autowired
    PrestitiPerStudioRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(PrestitiPerStudiareEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<PrestitiPerStudiareEntity> entities) {
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
    public Iterable<PrestitiPerStudiareEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<PrestitiPerStudiareEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<PrestitiPerStudiareEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public PrestitiPerStudiareEntity save(PrestitiPerStudiareEntity entity) {
        return repository.save(entity);
    }

    public Iterable<PrestitiPerStudiareEntity> saveAll(Iterable<PrestitiPerStudiareEntity> entities) {
        return repository.saveAll(entities);
    }
}
