package com.project.bebudgeting.service.annuali.usciteservice.bolletteservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliobollette.BolletteElettricitaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorybollette.BolletteElettricitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(BolletteElettricitaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<BolletteElettricitaEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<BolletteElettricitaEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return BolletteElettricitaEntity
     */
    // SAVE
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
