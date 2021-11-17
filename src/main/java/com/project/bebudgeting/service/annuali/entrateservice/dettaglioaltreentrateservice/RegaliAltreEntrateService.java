package com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate.RegaliAltreEntrateRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliAltreEntrateService {
    @Autowired
    RegaliAltreEntrateRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entityToDelete
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    public void delete(RegaliAltreEntrateEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<RegaliAltreEntrateEntity> entitiesToDelete) {
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
     * @return List<RegaliAltreEntrateEntity>
     */
    // FIND
    public List<RegaliAltreEntrateEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<RegaliAltreEntrateEntity> ret = new ArrayList<RegaliAltreEntrateEntity>();
        repository.findAll().forEach(entity -> {
            ret.add(entity);
        });
        return ret;
    }

    /**
     * @return Iterable<RegaliAltreEntrateEntity>
     */
    public Iterable<RegaliAltreEntrateEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<RegaliAltreEntrateEntity>
     */
    public Iterable<RegaliAltreEntrateEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<RegaliAltreEntrateEntity>
     */
    public Optional<RegaliAltreEntrateEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entityToSave
     * @return RegaliAltreEntrateEntity
     */
    // SAVE
    public RegaliAltreEntrateEntity save(RegaliAltreEntrateEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<RegaliAltreEntrateEntity>
     */
    public Iterable<RegaliAltreEntrateEntity> saveAll(Iterable<RegaliAltreEntrateEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
