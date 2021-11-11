package com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate.DividendiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import org.apache.commons.lang3.NotImplementedException;

@Service
public class DividendiService {
    @Autowired
    DividendiRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    /**
     * @param entityToDelete
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    // DELETE
    public void delete(DividendiEntity entityToDelete)
            throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null)
            throw new NullPointerException("Item is not set");
        if (repository.existsById(entityToDelete.getId()))
            repository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<DividendiEntity> entitiesToDelete) {
        List<Integer> ids = new ArrayList<>();
        entitiesToDelete.forEach(entity -> {
            ids.add(entity.getId());
        });
        entitiesToDelete.forEach(entity -> {
            try {
                delete(entity);
            } catch (NotImplementedException | NullPointerException | NotFoundException e) {
                e.printStackTrace();
            }
        });
        if (repository.findAllById(ids) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id))
            repository.deleteById(id);
        throw new NotFoundException("Item not found");
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param altreEntrateId
     * @return List<DividendiEntity>
     */
    // FIND
    public List<DividendiEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<DividendiEntity> ret = new ArrayList<DividendiEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    /**
     * @return Iterable<DividendiEntity>
     */
    public Iterable<DividendiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<DividendiEntity>
     */
    public Iterable<DividendiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<DividendiEntity>
     */
    public Optional<DividendiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entityToSave
     * @return DividendiEntity
     */
    // SAVE
    public DividendiEntity save(DividendiEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<DividendiEntity>
     */
    public Iterable<DividendiEntity> saveAll(Iterable<DividendiEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
