package com.project.bebudgeting.service.annuali.usciteservice.spesequotidianeservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryspesequotidiane.IgienePersonaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class IgienePersonaleService {
    @Autowired
    IgienePersonaleRepository repository;

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
    public void delete(IgienePersonaleEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<IgienePersonaleEntity> entities) {
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
     * @return Iterable<IgienePersonaleEntity>
     */
    // FIND
    public Iterable<IgienePersonaleEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<IgienePersonaleEntity>
     */
    public Iterable<IgienePersonaleEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<IgienePersonaleEntity>
     */
    public Optional<IgienePersonaleEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return IgienePersonaleEntity
     */
    // SAVE
    public IgienePersonaleEntity save(IgienePersonaleEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<IgienePersonaleEntity>
     */
    public Iterable<IgienePersonaleEntity> saveAll(Iterable<IgienePersonaleEntity> entities) {
        return repository.saveAll(entities);
    }
}
