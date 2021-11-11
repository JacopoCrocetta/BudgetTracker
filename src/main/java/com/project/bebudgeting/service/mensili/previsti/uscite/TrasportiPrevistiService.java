package com.project.bebudgeting.service.mensili.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.uscite.TrasportiPrevistiEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.uscite.TrasportiPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TrasportiPrevistiService {
    @Autowired
    TrasportiPrevistiRepository repository;

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
    public void delete(TrasportiPrevistiEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<TrasportiPrevistiEntity> entities) {
        repository.deleteAll(entities);
    }

    /**
     * @param ids
     */
    public void deleteAllByID(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<TrasportiPrevistiEntity>
     */
    // FIND
    public Iterable<TrasportiPrevistiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TrasportiPrevistiEntity>
     */
    public Iterable<TrasportiPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TrasportiPrevistiEntity>
     */
    public Optional<TrasportiPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return TrasportiPrevistiEntity
     */
    // SAVE
    public TrasportiPrevistiEntity save(TrasportiPrevistiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<TrasportiPrevistiEntity>
     */
    public Iterable<TrasportiPrevistiEntity> saveAll(Iterable<TrasportiPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
