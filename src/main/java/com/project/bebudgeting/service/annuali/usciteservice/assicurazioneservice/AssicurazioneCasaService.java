package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneCasaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssicurazioneCasaService {
    @Autowired
    AssicurazioneCasaRepository repository;

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
    public void delete(AssicurazioneCasaEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AssicurazioneCasaEntity> entitiesToDelete) {
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
     * @return Iterable<AssicurazioneCasaEntity>
     */
    public Iterable<AssicurazioneCasaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AssicurazioneCasaEntity>
     */
    public Iterable<AssicurazioneCasaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AssicurazioneCasaEntity>
     */
    public Optional<AssicurazioneCasaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entityToSave
     * @return AssicurazioneCasaEntity
     */
    public AssicurazioneCasaEntity save(AssicurazioneCasaEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AssicurazioneCasaEntity>
     */
    public Iterable<AssicurazioneCasaEntity> saveAll(Iterable<AssicurazioneCasaEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
