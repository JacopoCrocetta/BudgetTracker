package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.BustaPagaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BustaPagaService {
    @Autowired
    BustaPagaRepository repository;

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
    public void delete(BustaPagaEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<BustaPagaEntity> entitiesToDelete) {
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
     * @return Iterable<BustaPagaEntity>
     */
    public Iterable<BustaPagaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<BustaPagaEntity>
     */
    public Iterable<BustaPagaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<BustaPagaEntity>
     */
    public Optional<BustaPagaEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param salarioId
     * @return List<BustaPagaEntity>
     */
    public List<BustaPagaEntity> findBySalarioId(int salarioId) {
        List<BustaPagaEntity> ret = new ArrayList<BustaPagaEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    /**
     * @param entityToSave
     * @return BustaPagaEntity
     */
    // SAVE
    public BustaPagaEntity save(BustaPagaEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<BustaPagaEntity>
     */
    public Iterable<BustaPagaEntity> saveAll(Iterable<BustaPagaEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
