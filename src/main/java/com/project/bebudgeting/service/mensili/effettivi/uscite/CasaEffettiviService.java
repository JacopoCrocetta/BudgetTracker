package com.project.bebudgeting.service.mensili.effettivi.uscite;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.uscite.CasaEffettiviEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.uscite.CasaEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CasaEffettiviService {
    @Autowired
    CasaEffettiviRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    public void delete(CasaEffettiviEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<CasaEffettiviEntity> entities) {
        repository.deleteAll(entities);
    }

    /**
     * @param ids
     */
    public void deleteAllByID(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<CasaEffettiviEntity>
     */
    // FIND
    public Iterable<CasaEffettiviEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<CasaEffettiviEntity>
     */
    public Iterable<CasaEffettiviEntity> findAllByIds(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<CasaEffettiviEntity>
     */
    public Optional<CasaEffettiviEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return CasaEffettiviEntity
     */
    // SAVE
    public CasaEffettiviEntity save(CasaEffettiviEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<CasaEffettiviEntity>
     */
    public Iterable<CasaEffettiviEntity> saveAll(Iterable<CasaEffettiviEntity> entities) {
        return repository.saveAll(entities);
    }
}
