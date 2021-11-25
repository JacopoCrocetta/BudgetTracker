package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.CommissioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissioniService {
    @Autowired
    CommissioniRepository repository;

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
    public void delete(CommissioniEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<CommissioniEntity> entitiesToDelete) {
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
     * @return Iterable<CommissioniEntity>
     */
    public Iterable<CommissioniEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<CommissioniEntity>
     */
    public Iterable<CommissioniEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<CommissioniEntity>
     */
    public Optional<CommissioniEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param salarioId
     * @return List<CommissioniEntity>
     */
    public List<CommissioniEntity> findBySalarioId(int salarioId) {
        List<CommissioniEntity> ret = new ArrayList<CommissioniEntity>();
        repository.findAll().forEach(entity -> {
            ret.add(entity);
        });
        return ret;
    }

    /**
     * @param entityToSave
     * @return CommissioniEntity
     */
    // SAVE
    public CommissioniEntity save(CommissioniEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<CommissioniEntity>
     */
    public Iterable<CommissioniEntity> saveAll(Iterable<CommissioniEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
