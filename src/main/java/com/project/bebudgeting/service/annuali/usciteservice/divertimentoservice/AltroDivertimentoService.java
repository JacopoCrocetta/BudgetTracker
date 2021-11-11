package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.AltroDivertimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AltroDivertimentoService {
    @Autowired
    AltroDivertimentoRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(AltroDivertimentoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<AltroDivertimentoEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not Found");
        }
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<AltroDivertimentoEntity>
     */
    // FIND
    public Iterable<AltroDivertimentoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<AltroDivertimentoEntity>
     */
    public Iterable<AltroDivertimentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<AltroDivertimentoEntity>
     */
    public Optional<AltroDivertimentoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return AltroDivertimentoEntity
     */
    // SAVE
    public AltroDivertimentoEntity save(AltroDivertimentoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<AltroDivertimentoEntity>
     */
    public Iterable<AltroDivertimentoEntity> saveAll(Iterable<AltroDivertimentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
