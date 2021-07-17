package com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.repositoryanimalidomestici.GiocattoliRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiocattoliService {
    @Autowired
    GiocattoliRepository repository;

    public long count() {
        return repository.count();
    }

    //DELETE
    public void delete(GiocattoliEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<GiocattoliEntity> entitiesToDelete) {
        entitiesToDelete.forEach(giocattoliEntity -> {
            try {
                this.delete(giocattoliEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
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

    //FIND
    public Iterable<GiocattoliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<GiocattoliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<GiocattoliEntity> findById(int id) {
        return repository.findById(id);
    }

    //SAVE
    public GiocattoliEntity save(GiocattoliEntity entity) {
        return repository.save(entity);
    }

    public Iterable<GiocattoliEntity> saveAll(Iterable<GiocattoliEntity> entities) {
        return repository.saveAll(entities);
    }
}
