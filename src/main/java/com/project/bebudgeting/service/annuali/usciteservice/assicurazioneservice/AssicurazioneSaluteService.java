package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneSaluteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssicurazioneSaluteService {
    @Autowired
    AssicurazioneSaluteRepository repository;

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
    public void delete(AssicurazioneSaluteEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AssicurazioneSaluteEntity> entitiesToDelete) {
        entitiesToDelete.forEach(entity -> {
            this.delete(entity);
        });
    }

    public void deleteAll() {
        repository.deleteAll();
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
            repository.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<AssicurazioneSaluteEntity>
     */
    public Iterable<AssicurazioneSaluteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AssicurazioneSaluteEntity>
     */
    public Iterable<AssicurazioneSaluteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AssicurazioneSaluteEntity>
     */
    public Optional<AssicurazioneSaluteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entityToSave
     * @return AssicurazioneSaluteEntity
     */
    public AssicurazioneSaluteEntity save(AssicurazioneSaluteEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AssicurazioneSaluteEntity>
     */
    public Iterable<AssicurazioneSaluteEntity> saveAll(Iterable<AssicurazioneSaluteEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
