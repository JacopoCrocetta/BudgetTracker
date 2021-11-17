package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.ManceEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.ManceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManceService {
    @Autowired
    ManceRepository repository;

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
    public void delete(ManceEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<ManceEntity> entitiesToDelete) {
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

    // FIND
    /**
     * @return Iterable<ManceEntity>
     */
    public Iterable<ManceEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<ManceEntity>
     */
    public Iterable<ManceEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<ManceEntity>
     */
    public Optional<ManceEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param salarioId
     * @return List<ManceEntity>
     */
    public List<ManceEntity> findBySalarioId(int salarioId) {
        List<ManceEntity> ret = new ArrayList<ManceEntity>();
        repository.findAll().forEach(entity -> {
            ret.add(entity);
        });
        return ret;
    }

    // SAVE
    /**
     * @param entityToSave
     * @return ManceEntity
     */
    public ManceEntity save(ManceEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<ManceEntity>
     */
    public Iterable<ManceEntity> saveAll(Iterable<ManceEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
