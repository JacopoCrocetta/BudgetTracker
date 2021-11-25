package com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate.InteressiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteressiService {
    @Autowired
    InteressiRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    /**
     * @param entityToDelete
     */
    // DELETE
    public void delete(InteressiEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<InteressiEntity> entitiesToDelete) {
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
     * @return List<InteressiEntity>
     */
    // FIND
    public List<InteressiEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<InteressiEntity> ret = new ArrayList<InteressiEntity>();
        repository.findAll().forEach(entity -> {
            ret.add(entity);
        });
        return ret;
    }

    /**
     * @return Iterable<InteressiEntity>
     */
    public Iterable<InteressiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<InteressiEntity>
     */
    public Iterable<InteressiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<InteressiEntity>
     */
    public Optional<InteressiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entityToSave
     * @return InteressiEntity
     */
    // SAVE
    public InteressiEntity save(InteressiEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<InteressiEntity>
     */
    public Iterable<InteressiEntity> saveAll(Iterable<InteressiEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
