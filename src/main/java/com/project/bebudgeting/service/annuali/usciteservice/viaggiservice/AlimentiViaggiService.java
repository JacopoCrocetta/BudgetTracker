package com.project.bebudgeting.service.annuali.usciteservice.viaggiservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi.AlimentiViaggiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AlimentiViaggiService {
    @Autowired
    AlimentiViaggiRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(AlimentiViaggiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AlimentiViaggiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(alimentiEntity -> {
            try {
                this.delete(alimentiEntity);
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
        }
        throw new NotFoundException("Item not found");
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
     * @return Iterable<AlimentiViaggiEntity>
     */
    // FIND
    public Iterable<AlimentiViaggiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AlimentiViaggiEntity>
     */
    public Iterable<AlimentiViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AlimentiViaggiEntity>
     */
    public Optional<AlimentiViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AlimentiViaggiEntity
     */
    // SAVE
    public AlimentiViaggiEntity save(AlimentiViaggiEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AlimentiViaggiEntity>
     */
    public Iterable<AlimentiViaggiEntity> saveAll(Iterable<AlimentiViaggiEntity> entities) {
        return repository.saveAll(entities);
    }
}
