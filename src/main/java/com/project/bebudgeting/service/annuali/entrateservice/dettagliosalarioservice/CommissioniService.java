package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.CommissioniRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    // DELETE
    public void delete(CommissioniEntity entityToDelete)
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
    public boolean deleteAll(Iterable<CommissioniEntity> entitiesToDelete) {
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
     * @return Iterable<CommissioniEntity>
     */
    // FIND
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
