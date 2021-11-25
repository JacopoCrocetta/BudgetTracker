package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.AltroDivertimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroDivertimentoService {
    @Autowired
    AltroDivertimentoRepository repository;

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
    public void delete(AltroDivertimentoEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroDivertimentoEntity> entities) {
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
     * @return Iterable<AltroDivertimentoEntity>
     */
    public Iterable<AltroDivertimentoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroDivertimentoEntity>
     */
    public Iterable<AltroDivertimentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroDivertimentoEntity>
     */
    public Optional<AltroDivertimentoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return AltroDivertimentoEntity
     */
    public AltroDivertimentoEntity save(AltroDivertimentoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroDivertimentoEntity>
     */
    public Iterable<AltroDivertimentoEntity> saveAll(Iterable<AltroDivertimentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
