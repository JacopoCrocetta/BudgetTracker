package com.project.bebudgeting.service.annuali.usciteservice.assicurazioneservice;

import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryassicurazione.AssicurazioneAutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entityToDelete
     * @throws NotFoundException
     */
    // DELETE
    public void delete(AssicurazioneAutoEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    /**
     * @param entitiesToDelete
     */
    public void deleteAll(List<AssicurazioneAutoEntity> entitiesToDelete) {
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
     * @return Iterable<AssicurazioneAutoEntity>
     */
    // FIND
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

    /**
     * @param entityToSave
     * @return AssicurazioneAutoEntity
     */
    // SAVE
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
