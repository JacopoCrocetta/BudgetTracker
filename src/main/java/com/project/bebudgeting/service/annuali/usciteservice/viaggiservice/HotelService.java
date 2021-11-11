package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.HotelEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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
     * @throws NotFoundException
     */
    public void delete(HotelEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<HotelEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
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
     * @return Iterable<HotelEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return HotelEntity
     */
    // SAVE
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
