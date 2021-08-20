package com.project.bebudgeting.annuale.service.entrateservice;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.AltreEntrateRepository;
import com.project.bebudgeting.annuale.service.entrateservice.dettaglioaltreentrateservice.*;
import javassist.NotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AltreEntrateService {
    @Autowired
    AltreEntrateRepository repository;

    @Autowired
    AltroEService sAltroEService;

    @Autowired
    DividendiService dividendiService;

    @Autowired
    InteressiService interessiService;

    @Autowired
    RimborsiService rimborsiService;

    @Autowired
    RegaliAltreEntrateService regaliService;

    @Autowired
    TrasferimentoRisparmiService trasferimentoRisparmiService;

    public long count() {
        return repository.count();
    }

    // FIND
    public Iterable<AltreEntrateEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AltreEntrateEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AltreEntrateEntity> findById(int id) {
        return repository.findById(id);
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        sAltroEService.deleteById(altroEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }

                });
            }
            if (!repository.findById(id).get().getDividendiEntities().isEmpty()) {
                repository.findById(id).get().getDividendiEntities().forEach(dividentiEntity -> {
                    try {
                        dividendiService.deleteById(dividentiEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getInteressiEntities().isEmpty()) {
                repository.findById(id).get().getInteressiEntities().forEach(interessiEntity -> {
                    try {
                        interessiService.deleteById(interessiEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getRimborsiEntities().isEmpty()) {
                repository.findById(id).get().getRimborsiEntities().forEach(rimborsiEntity -> {
                    try {
                        rimborsiService.deleteById(rimborsiEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getRegaliEntities().isEmpty()) {
                repository.findById(id).get().getRegaliEntities().forEach(regaliEntity -> {
                    try {
                        regaliService.deleteById(regaliEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
            }
            if (!repository.findById(id).get().getTrasferimentoRisparmiEntities().isEmpty()) {
                repository.findById(id).get().getTrasferimentoRisparmiEntities().forEach(traferimentoRisparmiEntity -> {
                    try {
                        trasferimentoRisparmiService.deleteById(traferimentoRisparmiEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.deleteById(id);
        }
        throw new NotFoundException("Item not found");
    }

    public void deleteAll(Iterable<AltreEntrateEntity> entities) {
        entities.forEach(entity -> {
            if (!entity.getAltroEntities().isEmpty()) {
                sAltroEService.deleteAll(entity.getAltroEntities());
            }
            if (!entity.getDividendiEntities().isEmpty()) {
                dividendiService.deleteAll(entity.getDividendiEntities());
            }
            if (!entity.getInteressiEntities().isEmpty()) {
                interessiService.deleteAll(entity.getInteressiEntities());
            }
            if (!entity.getRimborsiEntities().isEmpty()) {
                rimborsiService.deleteAll(entity.getRimborsiEntities());
            }
            if (!entity.getRegaliEntities().isEmpty()) {
                regaliService.deleteAll(entity.getRegaliEntities());
            }
            if (!entity.getTrasferimentoRisparmiEntities().isEmpty()) {
                trasferimentoRisparmiService.deleteAll(entity.getTrasferimentoRisparmiEntities());
            }
        });
        repository.deleteAll(entities);
    }

    public void delete(AltreEntrateEntity entityToDelete)
            throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null)
            throw new NullPointerException("Item is not set");
        if (repository.existsById(entityToDelete.getId())) {
            if (!entityToDelete.getAltroEntities().isEmpty()) {
                sAltroEService.deleteAll(entityToDelete.getAltroEntities());
            }
            if (!entityToDelete.getDividendiEntities().isEmpty()) {
                dividendiService.deleteAll(entityToDelete.getDividendiEntities());
            }
            if (!entityToDelete.getInteressiEntities().isEmpty()) {
                interessiService.deleteAll(entityToDelete.getInteressiEntities());
            }
            if (!entityToDelete.getRimborsiEntities().isEmpty()) {
                rimborsiService.deleteAll(entityToDelete.getRimborsiEntities());
            }
            if (!entityToDelete.getRegaliEntities().isEmpty()) {
                regaliService.deleteAll(entityToDelete.getRegaliEntities());
            }
            if (!entityToDelete.getTrasferimentoRisparmiEntities().isEmpty()) {
                trasferimentoRisparmiService.deleteAll(entityToDelete.getTrasferimentoRisparmiEntities());
            }
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item not found");
    }

    // SAVE
    public AltreEntrateEntity save(AltreEntrateEntity entityToSave) {
        if (!entityToSave.getAltroEntities().isEmpty()) {
            sAltroEService.saveAll(entityToSave.getAltroEntities());
        }
        if (!entityToSave.getDividendiEntities().isEmpty()) {
            dividendiService.saveAll(entityToSave.getDividendiEntities());
        }
        if (!entityToSave.getInteressiEntities().isEmpty()) {
            interessiService.saveAll(entityToSave.getInteressiEntities());
        }
        if (!entityToSave.getRimborsiEntities().isEmpty()) {
            rimborsiService.saveAll(entityToSave.getRimborsiEntities());
        }
        if (!entityToSave.getRegaliEntities().isEmpty()) {
            regaliService.saveAll(entityToSave.getRegaliEntities());
        }
        if (!entityToSave.getTrasferimentoRisparmiEntities().isEmpty()) {
            trasferimentoRisparmiService.saveAll(entityToSave.getTrasferimentoRisparmiEntities());
        }
        return repository.save(entityToSave);
    }

    public Iterable<AltreEntrateEntity> saveAll(Iterable<AltreEntrateEntity> entitiesToSave) {
        entitiesToSave.forEach(entityToSave -> {
            this.save(entityToSave);
        });
        return entitiesToSave;
    }
}
