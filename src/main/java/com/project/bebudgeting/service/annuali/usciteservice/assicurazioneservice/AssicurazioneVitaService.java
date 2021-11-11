package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneVitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(AssicurazioneVitaEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AssicurazioneVitaEntity> entitiesToDelete) {
        entitiesToDelete.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            repository.deleteById(id);
        });
    }

    /**
     * @return Iterable<AssicurazioneVitaEntity>
     */
    // FIND
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

    /**
     * @param entityToSave
     * @return AssicurazioneVitaEntity
     */
    // SAVE
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
