package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneAutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssicurazioneAutoService {
    @Autowired
    AssicurazioneAutoRepository repository;

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
    public void delete(AssicurazioneAutoEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AssicurazioneAutoEntity> entitiesToDelete) {
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
     * @return Iterable<AssicurazioneAutoEntity>
     */
    public Iterable<AssicurazioneAutoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AssicurazioneAutoEntity>
     */
    public Iterable<AssicurazioneAutoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AssicurazioneAutoEntity>
     */
    public Optional<AssicurazioneAutoEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entityToSave
     * @return AssicurazioneAutoEntity
     */
    public AssicurazioneAutoEntity save(AssicurazioneAutoEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AssicurazioneAutoEntity>
     */
    public Iterable<AssicurazioneAutoEntity> saveAll(Iterable<AssicurazioneAutoEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
