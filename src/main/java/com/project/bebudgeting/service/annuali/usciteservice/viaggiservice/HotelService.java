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

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(HotelEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<HotelEntity> entities) {
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
    public Iterable<HotelEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<HotelEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<HotelEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public HotelEntity save(HotelEntity entity) {
        return repository.save(entity);
    }

    public Iterable<HotelEntity> saveAll(Iterable<HotelEntity> entities) {
        return repository.saveAll(entities);
    }
}
