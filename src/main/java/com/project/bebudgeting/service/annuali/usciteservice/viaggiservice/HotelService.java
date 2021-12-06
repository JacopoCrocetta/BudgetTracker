package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.HotelEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    HotelRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entity
     */
    public void delete(HotelEntity entity) {
        repository.delete(entity);
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<HotelEntity> entities) {
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
     * @return Iterable<HotelEntity>
     */
    public Iterable<HotelEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<HotelEntity>
     */
    public Iterable<HotelEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<HotelEntity>
     */
    public Optional<HotelEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return HotelEntity
     */
    public HotelEntity save(HotelEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<HotelEntity>
     */
    public Iterable<HotelEntity> saveAll(Iterable<HotelEntity> entities) {
        return repository.saveAll(entities);
    }
}
