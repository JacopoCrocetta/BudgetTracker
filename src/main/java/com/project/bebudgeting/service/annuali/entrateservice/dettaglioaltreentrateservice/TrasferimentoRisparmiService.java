package com.project.bebudgeting.service.annuali.entrateservice.dettaglioaltreentrateservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositoryaltreentrate.TrasferimentoRisparmiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TrasferimentoRisparmiService {
    @Autowired
    TrasferimentoRisparmiRepository repository;

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
    public void delete(TrasferimentoRisparmiEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<TrasferimentoRisparmiEntity> entitiesToDelete) {
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
    public void deleteById(int id) throws NotFoundException {
        repository.deleteById(id);
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
     * @param altreEntrateId
     * @return List<TrasferimentoRisparmiEntity>
     */
    // FIND
    public List<TrasferimentoRisparmiEntity> findAllByAltreEntrateId(int altreEntrateId) {
        List<TrasferimentoRisparmiEntity> ret = new ArrayList<TrasferimentoRisparmiEntity>();
        repository.findAll().forEach(entity -> {

            ret.add(entity);

        });
        return ret;
    }

    /**
     * @return Iterable<TrasferimentoRisparmiEntity>
     */
    public Iterable<TrasferimentoRisparmiEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<TrasferimentoRisparmiEntity>
     */
    public Iterable<TrasferimentoRisparmiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<TrasferimentoRisparmiEntity>
     */
    public Optional<TrasferimentoRisparmiEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entityToSave
     * @return TrasferimentoRisparmiEntity
     */
    // SAVE
    public TrasferimentoRisparmiEntity save(TrasferimentoRisparmiEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<TrasferimentoRisparmiEntity>
     */
    public Iterable<TrasferimentoRisparmiEntity> saveAll(Iterable<TrasferimentoRisparmiEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
