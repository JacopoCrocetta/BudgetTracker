package com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositorydivertimento.AltroDivertimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroDivertimentoService {
    @Autowired
    AltroDivertimentoRepository repository;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AltroDivertimentoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AltroDivertimentoEntity> entities) {
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
    public Iterable<AltroDivertimentoEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltroDivertimentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltroDivertimentoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AltroDivertimentoEntity save(AltroDivertimentoEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AltroDivertimentoEntity> saveAll(Iterable<AltroDivertimentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
