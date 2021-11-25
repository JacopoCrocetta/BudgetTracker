package com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate.DividendiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // DELETE
    /**
     * @param entityToDelete
     */
    public void delete(DividendiEntity entityToDelete) {
        repository.delete(entityToDelete);
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
            delete(entity);
        });
        if (repository.findAllById(ids) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param id
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            deleteById(id);
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
