package com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate.AltroAltreEntrateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroEService {
    @Autowired
    AltroAltreEntrateRepository repository;

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
    public void delete(AltroAltreEntrateEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<AltroAltreEntrateEntity> entitiesToDelete) {
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
     * @return List<AltroAltreEntrateEntity>
     */
    // FIND
    public List<AltroAltreEntrateEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<AltroAltreEntrateEntity> ret = new ArrayList<AltroAltreEntrateEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    /**
     * @return Iterable<AltroAltreEntrateEntity>
     */
    public Iterable<AltroAltreEntrateEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroAltreEntrateEntity>
     */
    public Iterable<AltroAltreEntrateEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroAltreEntrateEntity>
     */
    public Optional<AltroAltreEntrateEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entityToSave
     * @return AltroAltreEntrateEntity
     */
    // SAVE
    public AltroAltreEntrateEntity save(AltroAltreEntrateEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AltroAltreEntrateEntity>
     */
    public Iterable<AltroAltreEntrateEntity> saveAll(Iterable<AltroAltreEntrateEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}