package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.ManceEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.ManceRepository;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     * @throws NullPointerException
     * @throws NotImplementedException
     */
    // DELETE
    public void delete(ManceEntity entityToDelete)
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
    public boolean deleteAll(Iterable<ManceEntity> entitiesToDelete) {
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
     * @return Iterable<ManceEntity>
     */
    // FIND
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

    /**
     * @param entityToSave
     * @return ManceEntity
     */
    // SAVE
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
