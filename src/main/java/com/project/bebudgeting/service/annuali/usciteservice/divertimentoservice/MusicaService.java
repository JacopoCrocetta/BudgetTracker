package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.MusicaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    MusicaRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(MusicaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<MusicaEntity> entities) {
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
    public Iterable<MusicaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<MusicaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<MusicaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public MusicaEntity save(MusicaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<MusicaEntity> saveAll(Iterable<MusicaEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
