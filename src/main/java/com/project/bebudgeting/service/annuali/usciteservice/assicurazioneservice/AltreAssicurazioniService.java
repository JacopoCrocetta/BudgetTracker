package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AltreAssicurazioniRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(AltreAssicurazioniEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(List<AltreAssicurazioniEntity> entitiesToDelete) {
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
     * @return Iterable<AltreAssicurazioniEntity>
     */
    // FIND
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

    /**
     * @param entityToSave
     * @return AltreAssicurazioniEntity
     */
    // SAVE
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
