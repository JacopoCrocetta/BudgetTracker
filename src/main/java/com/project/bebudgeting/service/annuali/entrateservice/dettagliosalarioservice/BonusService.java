package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.BonusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusService {
    @Autowired
    BonusRepository repository;

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
    public void delete(BonusEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<BonusEntity> entitiesToDelete) {
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
     * @return Iterable<BonusEntity>
     */
    public Iterable<BonusEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BonusEntity>
     */
    public Iterable<BonusEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BonusEntity>
     */
    public Optional<BonusEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param salarioId
     * @return List<BonusEntity>
     */
    public List<BonusEntity> findBySalarioId(int salarioId) {
        List<BonusEntity> ret = new ArrayList<BonusEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    /**
     * @param entityToSave
     * @return BonusEntity
     */
    // SAVE
    public BonusEntity save(BonusEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<BonusEntity>
     */
    public Iterable<BonusEntity> saveAll(Iterable<BonusEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
