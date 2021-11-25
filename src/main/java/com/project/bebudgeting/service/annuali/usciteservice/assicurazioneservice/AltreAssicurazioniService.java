package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AltreAssicurazioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltreAssicurazioniService {
    @Autowired
    AltreAssicurazioniRepository repository;

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
    public void delete(AltreAssicurazioniEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AltreAssicurazioniEntity> entitiesToDelete) {
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
     * @return Iterable<AltreAssicurazioniEntity>
     */
    public Iterable<AltreAssicurazioniEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltreAssicurazioniEntity>
     */
    public Iterable<AltreAssicurazioniEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltreAssicurazioniEntity>
     */
    public Optional<AltreAssicurazioniEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entityToSave
     * @return AltreAssicurazioniEntity
     */
    public AltreAssicurazioniEntity save(AltreAssicurazioniEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AltreAssicurazioniEntity>
     */
    public Iterable<AltreAssicurazioniEntity> saveAll(Iterable<AltreAssicurazioniEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
