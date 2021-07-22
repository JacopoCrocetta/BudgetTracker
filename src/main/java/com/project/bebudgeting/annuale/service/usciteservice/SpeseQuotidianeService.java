package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.SpeseQuotidianeEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.SpeseQuotidianeRepository;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.AbbonamentiService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.AltreSpeseQuotidianeService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.IgienePersonaleService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.LavanderiaService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.ParrucchiereService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.RistorantiService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.SupermercatoService;
import com.project.bebudgeting.annuale.service.usciteservice.spesequotidianeservice.VestitiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class SpeseQuotidianeService {
    @Autowired
    SpeseQuotidianeRepository repository;

    @Autowired
    AbbonamentiService abbonamentiService;

    @Autowired
    AltreSpeseQuotidianeService altreSpeseQuotidianeService;

    @Autowired
    IgienePersonaleService igienePersonaleService;

    @Autowired
    LavanderiaService lavanderiaService;

    @Autowired
    ParrucchiereService parrucchiereService;

    @Autowired
    RistorantiService ristorantiService;

    @Autowired
    SupermercatoService supermercatoService;

    @Autowired
    VestitiService vestitiService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        abbonamentiService.deleteAll();
        altreSpeseQuotidianeService.deleteAll();
        igienePersonaleService.deleteAll();
        lavanderiaService.deleteAll();
        parrucchiereService.deleteAll();
        ristorantiService.deleteAll();
        supermercatoService.deleteAll();
        vestitiService.deleteAll();
        repository.deleteAll();
    }

    public void delete(SpeseQuotidianeEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent()) {
            if (!repository.findById(entity.getId()).get().getAbbonamentiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAbbonamentiEntities().forEach(abbonamentoEntity -> {
                    try {
                        abbonamentiService.delete(abbonamentoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getAltroEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altreSpeseQuotidianeService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getIgienePersonaleEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getIgienePersonaleEntities().forEach(igieneEntity -> {
                    try {
                        igienePersonaleService.delete(igieneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getLavanderiaEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getLavanderiaEntities().forEach(lavanderiaEntity -> {
                    try {
                        lavanderiaService.delete(lavanderiaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getParrucchiereEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getParrucchiereEntities().forEach(parrucchiereEntity -> {
                    try {
                        parrucchiereService.delete(parrucchiereEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getRistorantiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getRistorantiEntities().forEach(ristoranteEntity -> {
                    try {
                        ristorantiService.delete(ristoranteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getSupermercatoEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getSupermercatoEntities().forEach(supermercattoEntity -> {
                    try {
                        supermercatoService.delete(supermercattoEntity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getVestitiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getVestitiEntities().forEach(vestitiEntity -> {
                    try {
                        vestitiService.delete(vestitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<SpeseQuotidianeEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)||repository.findById(id).isPresent()) {
            if (!repository.findById(id).get().getAbbonamentiEntities().isEmpty()) {
                abbonamentiService.deleteById(id);
            }
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                altreSpeseQuotidianeService.deleteById(id);
            }
            if (!repository.findById(id).get().getIgienePersonaleEntities().isEmpty()) {
                igienePersonaleService.deleteById(id);
            }
            if (!repository.findById(id).get().getLavanderiaEntities().isEmpty()) {
                lavanderiaService.deleteById(id);
            }
            if (!repository.findById(id).get().getParrucchiereEntities().isEmpty()) {
                parrucchiereService.deleteById(id);
            }
            if (!repository.findById(id).get().getRistorantiEntities().isEmpty()) {
                ristorantiService.deleteById(id);
            }
            if (!repository.findById(id).get().getSupermercatoEntities().isEmpty()) {
                supermercatoService.deleteById(id);
            }
            if (!repository.findById(id).get().getVestitiEntities().isEmpty()) {
                vestitiService.deleteById(id);
            }
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
    public Iterable<SpeseQuotidianeEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SpeseQuotidianeEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SpeseQuotidianeEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public SpeseQuotidianeEntity save(SpeseQuotidianeEntity entity) {
        abbonamentiService.saveAll(entity.getAbbonamentiEntities());
        altreSpeseQuotidianeService.saveAll(entity.getAltroEntities());
        igienePersonaleService.saveAll(entity.getIgienePersonaleEntities());
        lavanderiaService.saveAll(entity.getLavanderiaEntities());
        parrucchiereService.saveAll(entity.getParrucchiereEntities());
        ristorantiService.saveAll(entity.getRistorantiEntities());
        supermercatoService.saveAll(entity.getSupermercatoEntities());
        vestitiService.saveAll(entity.getVestitiEntities());
        return repository.save(entity);
    }

    public Iterable<SpeseQuotidianeEntity> saveAll(Iterable<SpeseQuotidianeEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
