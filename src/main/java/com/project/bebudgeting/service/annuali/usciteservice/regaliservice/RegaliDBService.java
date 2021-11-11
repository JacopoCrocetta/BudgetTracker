package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.RegaliDBEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.RegaliDBRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliDBService {
    @Autowired
    RegaliDBRepository repository;

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
    public void delete(RegaliDBEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<RegaliDBEntity> entities) {
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
     * @return Iterable<RegaliDBEntity>
     */
    // FIND
    public Iterable<RegaliDBEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RegaliDBEntity>
     */
    public Iterable<RegaliDBEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RegaliDBEntity>
     */
    public Optional<RegaliDBEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return RegaliDBEntity
     */
    // SAVE
    public RegaliDBEntity save(RegaliDBEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<RegaliDBEntity>
     */
    public Iterable<RegaliDBEntity> saveAll(Iterable<RegaliDBEntity> entities) {
        return repository.saveAll(entities);
    }
}
