package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.LibriDivertimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibriDivertimentoService {
    @Autowired
    LibriDivertimentoRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entity
     */
    public void delete(LibriDivertimentoEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<LibriDivertimentoEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            this.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<LibriDivertimentoEntity>
     */
    public Iterable<LibriDivertimentoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LibriDivertimentoEntity>
     */
    public Iterable<LibriDivertimentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LibriDivertimentoEntity>
     */
    public Optional<LibriDivertimentoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return LibriDivertimentoEntity
     */
    public LibriDivertimentoEntity save(LibriDivertimentoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LibriDivertimentoEntity>
     */
    public Iterable<LibriDivertimentoEntity> saveAll(Iterable<LibriDivertimentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
