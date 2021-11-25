package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneVitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssicurazioneVitaService {
    @Autowired
    AssicurazioneVitaRepository repository;

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
    public void delete(AssicurazioneVitaEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AssicurazioneVitaEntity> entitiesToDelete) {
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
     * @return Iterable<AssicurazioneVitaEntity>
     */
    public Iterable<AssicurazioneVitaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AssicurazioneVitaEntity>
     */
    public Iterable<AssicurazioneVitaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AssicurazioneVitaEntity>
     */
    public Optional<AssicurazioneVitaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entityToSave
     * @return AssicurazioneVitaEntity
     */
    public AssicurazioneVitaEntity save(AssicurazioneVitaEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AssicurazioneVitaEntity>
     */
    public Iterable<AssicurazioneVitaEntity> saveAll(Iterable<AssicurazioneVitaEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
