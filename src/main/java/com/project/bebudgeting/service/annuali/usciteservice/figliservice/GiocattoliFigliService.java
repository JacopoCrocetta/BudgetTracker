package com.project.bebudgeting.service.annuali.usciteservice.figliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryfigli.GiocattoliFigliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class GiocattoliFigliService {
    @Autowired
    GiocattoliFigliRepository repository;

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
    public void delete(GiocattoliFigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<GiocattoliFigliEntity> entities) {
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
            throw new NotFoundException("Item not Found");
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
     * @return Iterable<GiocattoliFigliEntity>
     */
    // FIND
    public Iterable<GiocattoliFigliEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<GiocattoliFigliEntity>
     */
    public Iterable<GiocattoliFigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<GiocattoliFigliEntity>
     */
    public Optional<GiocattoliFigliEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return GiocattoliFigliEntity
     */
    // SAVE
    public GiocattoliFigliEntity save(GiocattoliFigliEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<GiocattoliFigliEntity>
     */
    public Iterable<GiocattoliFigliEntity> saveAll(Iterable<GiocattoliFigliEntity> entities) {
        return repository.saveAll(entities);
    }
}
