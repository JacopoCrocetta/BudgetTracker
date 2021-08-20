package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.RegaliUsciteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.RegaliUsciteRepository;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.AltroRegaliService;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.DonazioniBeneficienzaService;
import com.project.bebudgeting.annuale.service.usciteservice.regaliservice.RegaliDBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class RegaliUsciteService {
    @Autowired
    RegaliUsciteRepository repository;

    @Autowired
    AltroRegaliService altroRegaliService;

    @Autowired
    DonazioniBeneficienzaService donazioniBeneficienzaService;

    @Autowired
    RegaliDBService regaliDBService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroRegaliService.deleteAll();
        donazioniBeneficienzaService.deleteAll();
        regaliDBService.deleteAll();
        repository.deleteAll();
    }

    public void delete(RegaliUsciteEntity entity) throws NotFoundException {
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
                        regaliDBService.delete(regaliEntity);
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

    public void deleteAll(Iterable<RegaliUsciteEntity> entities) {
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
                    regaliDBService.delete(regaliEntity);
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
    public Iterable<RegaliUsciteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<RegaliUsciteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<RegaliUsciteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public RegaliUsciteEntity save(RegaliUsciteEntity entity) {
        altroRegaliService.saveAll(entity.getAltroEntities());
        donazioniBeneficienzaService.saveAll(entity.getDonazioniBeneficenzaEntities());
        regaliDBService.saveAll(entity.getRegaliDBEntities());
        return repository.save(entity);
    }

    public Iterable<RegaliUsciteEntity> saveAll(Iterable<RegaliUsciteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
