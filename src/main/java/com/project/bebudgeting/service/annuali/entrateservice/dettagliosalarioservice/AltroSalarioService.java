package com.project.bebudgeting.service.annuali.entrateservice.dettagliosalarioservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.bebudgeting.entity.annuali.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.repository.annuali.entrateannuali.repositorydettaglisalario.AltroSalarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AltroSalarioService {
    @Autowired
    AltroSalarioRepository repository;

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
    public void delete(AltroSalarioEntity entityToDelete) {
        repository.delete(entityToDelete);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entitiesToDelete
     * @return boolean
     */
    public boolean deleteAll(Iterable<AltroSalarioEntity> entitiesToDelete) {
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
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            deleteById(id);
        });
    }

    // FIND
    /**
     * @param salarioId
     * @return List<AltroSalarioEntity>
     */
    public List<AltroSalarioEntity> findBySalarioId(int salarioId) {
        List<AltroSalarioEntity> ret = new ArrayList<AltroSalarioEntity>();
        repository.findAll().forEach(entity -> {
            ret.add(entity);
        });
        return ret;
    }

    /**
     * @return Iterable<AltroSalarioEntity>
     */
    public Iterable<AltroSalarioEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroSalarioEntity>
     */
    public Iterable<AltroSalarioEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroSalarioEntity>
     */
    public Optional<AltroSalarioEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entityToSave
     * @return AltroSalarioEntity
     */
    public AltroSalarioEntity save(AltroSalarioEntity entityToSave) {
        return repository.save(entityToSave);
    }

    /**
     * @param entitiesToSave
     * @return Iterable<AltroSalarioEntity>
     */
    public Iterable<AltroSalarioEntity> saveAll(Iterable<AltroSalarioEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
