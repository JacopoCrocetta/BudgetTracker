package com.project.bebudgeting.service.mensili.previsti.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.uscite.ViaggiPrevistiEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.uscite.ViaggiPrevistiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ViaggiPrevistiService {
    @Autowired
    ViaggiPrevistiRepository repository;

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
    public void delete(ViaggiPrevistiEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<ViaggiPrevistiEntity> entities) {
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
     * @return Iterable<ViaggiPrevistiEntity>
     */
    // FIND
    public Iterable<ViaggiPrevistiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ViaggiPrevistiEntity>
     */
    public Iterable<ViaggiPrevistiEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ViaggiPrevistiEntity>
     */
    public Optional<ViaggiPrevistiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return ViaggiPrevistiEntity
     */
    // SAVE
    public ViaggiPrevistiEntity save(ViaggiPrevistiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<ViaggiPrevistiEntity>
     */
    public Iterable<ViaggiPrevistiEntity> saveAll(Iterable<ViaggiPrevistiEntity> entities) {
        return repository.saveAll(entities);
    }
}
