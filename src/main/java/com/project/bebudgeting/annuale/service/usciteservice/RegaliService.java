package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.RegaliEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.RegaliRepository;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.AltroRegaliService;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.DonazioniBeneficienzaService;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.RegaliDBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliService {
    @Autowired
    RegaliRepository repository;

    @Autowired
    AltroRegaliService altroRegaliService;

    @Autowired
    DonazioniBeneficienzaService donazioniBeneficienzaService;

    @Autowired
    RegaliDBService regaliService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroRegaliService.deleteAll();
        donazioniBeneficienzaService.deleteAll();
        regaliService.deleteAll();
        repository.deleteAll();
    }

    public void delete(RegaliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (repository.findById(entity.getId()).isPresent()) {
                entity.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroRegaliService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                entity.getDonazioniBeneficenzaEntities().forEach(donazioniEntity -> {
                    try {
                        donazioniBeneficienzaService.delete(donazioniEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                entity.getRegaliDBEntities().forEach(regaliEntity -> {
                    try {
                        regaliService.delete(regaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.delete(entity);
            } else {
                throw new NotFoundException("Item not present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<RegaliEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id) || repository.findById(id).isPresent()) {
            repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                try {
                    altroRegaliService.delete(altroEntity);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            });
            repository.findById(id).get().getDonazioniBeneficenzaEntities().forEach(donazioniEntity -> {
                try {
                    donazioniBeneficienzaService.delete(donazioniEntity);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            });
            repository.findById(id).get().getRegaliDBEntities().forEach(regaliEntity -> {
                try {
                    regaliService.delete(regaliEntity);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            });
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
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
    public Iterable<RegaliEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RegaliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RegaliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RegaliEntity save(RegaliEntity entity) {
        altroRegaliService.saveAll(entity.getAltroEntities());
        donazioniBeneficienzaService.saveAll(entity.getDonazioniBeneficenzaEntities());
        regaliService.saveAll(entity.getRegaliDBEntities());
        return repository.save(entity);
    }

    public Iterable<RegaliEntity> saveAll(Iterable<RegaliEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
