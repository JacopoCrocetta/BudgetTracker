package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.DonazioniBeneficenzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonazioniBeneficienzaService {
    @Autowired
    DonazioniBeneficenzaRepository repository;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    /**
     * @param entity
     */
    public void delete(DonazioniBeneficenzaEntity entity) {
        repository.delete(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<DonazioniBeneficenzaEntity> entities) {
        entities.forEach(entity -> {
            this.delete(entity);
        });
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
            this.deleteById(id);
        });
    }

    // FIND
    /**
     * @return Iterable<DonazioniBeneficenzaEntity>
     */
    public Iterable<DonazioniBeneficenzaEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<DonazioniBeneficenzaEntity>
     */
    public Iterable<DonazioniBeneficenzaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<DonazioniBeneficenzaEntity>
     */
    public Optional<DonazioniBeneficenzaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    /**
     * @param entity
     * @return DonazioniBeneficenzaEntity
     */
    public DonazioniBeneficenzaEntity save(DonazioniBeneficenzaEntity entity) {
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<DonazioniBeneficenzaEntity>
     */
    public Iterable<DonazioniBeneficenzaEntity> saveAll(Iterable<DonazioniBeneficenzaEntity> entities) {
        return repository.saveAll(entities);
    }
}
