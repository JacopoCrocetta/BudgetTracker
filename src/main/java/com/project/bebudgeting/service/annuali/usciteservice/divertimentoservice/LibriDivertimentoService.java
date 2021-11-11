package com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositorydivertimento.LibriDivertimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class LibriDivertimentoService {
    @Autowired
    LibriDivertimentoRepository repository;

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
    public void delete(LibriDivertimentoEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<LibriDivertimentoEntity> entities) {
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
     * @return Iterable<LibriDivertimentoEntity>
     */
    // FIND
    public Iterable<LibriDivertimentoEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<LibriDivertimentoEntity>
     */
    public Iterable<LibriDivertimentoEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<LibriDivertimentoEntity>
     */
    public Optional<LibriDivertimentoEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return LibriDivertimentoEntity
     */
    // SAVE
    public LibriDivertimentoEntity save(LibriDivertimentoEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<LibriDivertimentoEntity>
     */
    public Iterable<LibriDivertimentoEntity> saveAll(Iterable<LibriDivertimentoEntity> entities) {
        return repository.saveAll(entities);
    }
}
