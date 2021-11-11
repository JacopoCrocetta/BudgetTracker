package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneSaluteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(AssicurazioneSaluteEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(Iterable<AssicurazioneSaluteEntity> entitiesToDelete) {
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
     * @return Iterable<AssicurazioneSaluteEntity>
     */
    // FIND
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

    /**
     * @param entityToSave
     * @return AssicurazioneSaluteEntity
     */
    // SAVE
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
