package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteElettricitaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteElettricitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolletteElettricitaService {
    @Autowired
    BolletteElettricitaRepository repository;

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
    public void delete(BolletteElettricitaEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteElettricitaEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
    }

    public void deleteAll() {
        repository.deleteAll();
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
     * @return Iterable<BolletteElettricitaEntity>
     */
    public Iterable<BolletteElettricitaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BolletteElettricitaEntity>
     */
    public Iterable<BolletteElettricitaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BolletteElettricitaEntity>
     */
    public Optional<BolletteElettricitaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return BolletteElettricitaEntity
     */
    public BolletteElettricitaEntity save(BolletteElettricitaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<BolletteElettricitaEntity>
     */
    public Iterable<BolletteElettricitaEntity> saveAll(Iterable<BolletteElettricitaEntity> entities) {
        return repository.saveAll(entities);
    }
}
