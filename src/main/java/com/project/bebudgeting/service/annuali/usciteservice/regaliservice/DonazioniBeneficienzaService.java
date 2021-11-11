package com.project.bebudgeting.service.annuali.usciteservice.regaliservice;

import java.util.Optional;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.repository.annuali.usciteannuali.repositoryregali.DonazioniBeneficenzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

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

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE
    public void delete(DonazioniBeneficenzaEntity entity) throws NotFoundException {
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
    public void deleteAll(Iterable<DonazioniBeneficenzaEntity> entities) {
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
     * @return Iterable<DonazioniBeneficenzaEntity>
     */
    // FIND
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

    /**
     * @param entity
     * @return DonazioniBeneficenzaEntity
     */
    // SAVE
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
