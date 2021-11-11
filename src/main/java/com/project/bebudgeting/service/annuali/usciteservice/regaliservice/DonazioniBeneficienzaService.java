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

    public long count() {
        return repository.count();
    }

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

    public void deleteAll(Iterable<DonazioniBeneficenzaEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not Found");
        }
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<DonazioniBeneficenzaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<DonazioniBeneficenzaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<DonazioniBeneficenzaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public DonazioniBeneficenzaEntity save(DonazioniBeneficenzaEntity entity) {
        return repository.save(entity);
    }

    public Iterable<DonazioniBeneficenzaEntity> saveAll(Iterable<DonazioniBeneficenzaEntity> entities) {
        return repository.saveAll(entities);
    }
}
