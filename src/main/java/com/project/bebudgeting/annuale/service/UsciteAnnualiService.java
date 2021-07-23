package com.project.bebudgeting.annuale.service;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;
import com.project.bebudgeting.annuale.repository.UsciteAnnualiRepository;
import com.project.bebudgeting.annuale.service.usciteservice.AltreUsciteService;
import com.project.bebudgeting.annuale.service.usciteservice.AnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.AssicurazioneService;
import com.project.bebudgeting.annuale.service.usciteservice.BolletteService;
import com.project.bebudgeting.annuale.service.usciteservice.CasaService;
import com.project.bebudgeting.annuale.service.usciteservice.DebitiService;
import com.project.bebudgeting.annuale.service.usciteservice.DivertimentoService;
import com.project.bebudgeting.annuale.service.usciteservice.FigliService;
import com.project.bebudgeting.annuale.service.usciteservice.IstruzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.RegaliService;
import com.project.bebudgeting.annuale.service.usciteservice.SpeseMedicheService;
import com.project.bebudgeting.annuale.service.usciteservice.SpeseQuotidianeService;
import com.project.bebudgeting.annuale.service.usciteservice.TecnologiaService;
import com.project.bebudgeting.annuale.service.usciteservice.TrasportiService;
import com.project.bebudgeting.annuale.service.usciteservice.ViaggiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class UsciteAnnualiService {
    @Autowired
    UsciteAnnualiRepository repository;

    @Autowired
    AltreUsciteService altreUsciteService;

    @Autowired
    AnimaliDomesticiService animaliDomesticiService;

    @Autowired
    AssicurazioneService assicurazioneService;

    @Autowired
    BolletteService bolletteService;

    @Autowired
    CasaService casaService;

    @Autowired
    DebitiService debitiService;

    @Autowired
    DivertimentoService divertimentoService;

    @Autowired
    FigliService figliService;

    @Autowired
    IstruzioneService istruzioneService;

    @Autowired
    RegaliService regaliService;

    @Autowired
    SpeseMedicheService speseMedicheService;

    @Autowired
    SpeseQuotidianeService speseQuotidianeService;

    @Autowired
    TecnologiaService tecnologiaService;

    @Autowired
    TrasportiService trasportiService;

    @Autowired
    ViaggiService viaggiService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altreUsciteService.deleteAll();
        animaliDomesticiService.deleteAll();
        assicurazioneService.deleteAll();
        bolletteService.deleteAll();
        casaService.deleteAll();
        debitiService.deleteAll();
        divertimentoService.deleteAll();
        figliService.deleteAll();
        istruzioneService.deleteAll();
        regaliService.deleteAll();
        speseMedicheService.deleteAll();
        speseQuotidianeService.deleteAll();
        tecnologiaService.deleteAll();
        trasportiService.deleteAll();
        viaggiService.deleteAll();
        repository.deleteAll();
    }

    public void delete(UsciteAnnualiEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            if (!repository.findById(entity.getId()).get().getAltreUsciteEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAltreUsciteEntities().forEach(altreUsciteEntity -> {
                    try {
                        altreUsciteService.delete(altreUsciteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getAnimaliDomesticiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAnimaliDomesticiEntities().forEach(animaliEntity -> {
                    try {
                        animaliDomesticiService.delete(animaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getAssicurazioneEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAssicurazioneEntities().forEach(assicurazioneEntity -> {
                    try {
                        assicurazioneService.delete(assicurazioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getBolletteEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getBolletteEntities().forEach(bolletteEntity -> {
                    try {
                        bolletteService.delete(bolletteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getCasaEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getCasaEntities().forEach(casaEntity -> {
                    try {
                        casaService.delete(casaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getDebitiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getDebitiEntities().forEach(debitiEntity -> {
                    try {
                        debitiService.delete(debitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getDivertimentoEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getDivertimentoEntities().forEach(divertimentoEntity -> {
                    try {
                        divertimentoService.delete(divertimentoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getFigliEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getFigliEntities().forEach(figliEntity -> {
                    try {
                        figliService.delete(figliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getIstruzioneEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getIstruzioneEntities().forEach(istruzioneEntity -> {
                    try {
                        istruzioneService.delete(istruzioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getRegaliEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getRegaliEntities().forEach(regaliEntity -> {
                    try {
                        regaliService.delete(regaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getSpeseMedicheEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getSpeseMedicheEntities().forEach(speseMedicheEntity -> {
                    try {
                        speseMedicheService.delete(speseMedicheEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getSpeseQuotidianeEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getSpeseQuotidianeEntities()
                        .forEach(speseQuotidianeEntity -> {
                            try {
                                speseQuotidianeService.delete(speseQuotidianeEntity);
                            } catch (NotFoundException e) {
                                e.printStackTrace();
                            }
                        });
            }
            if (!repository.findById(entity.getId()).get().getTecnologiaEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getTecnologiaEntities().forEach(tecnologiaEntity -> {
                    try {
                        tecnologiaService.delete(tecnologiaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getTrasportiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getTrasportiEntities().forEach(trasportiEntity -> {
                    try {
                        trasportiService.delete(trasportiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getViaggiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getViaggiEntities().forEach(viaggiEntity -> {
                    try {
                        viaggiService.delete(viaggiEntity);
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

    public void deleteAll(Iterable<UsciteAnnualiEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent() || !repository.findById(id).isEmpty()) {
            if (!repository.findById(id).get().getAltreUsciteEntities().isEmpty()) {
                repository.findById(id).get().getAltreUsciteEntities().forEach(altreUsciteEntity -> {
                    try {
                        altreUsciteService.deleteById(altreUsciteEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAnimaliDomesticiEntities().isEmpty()) {
                repository.findById(id).get().getAnimaliDomesticiEntities().forEach(animaliEntity -> {
                    try {
                        animaliDomesticiService.deleteById(animaliEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAssicurazioneEntities().isEmpty()) {
                repository.findById(id).get().getAssicurazioneEntities().forEach(assicurazioneEntity -> {
                    try {
                        assicurazioneService.deleteById(assicurazioneEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteEntities().isEmpty()) {
                repository.findById(id).get().getBolletteEntities().forEach(bolletteEntity -> {
                    try {
                        bolletteService.deleteById(bolletteEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getCasaEntities().isEmpty()) {
                repository.findById(id).get().getCasaEntities().forEach(casaEntity -> {
                    try {
                        casaService.deleteById(casaEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getDebitiEntities().isEmpty()) {
                repository.findById(id).get().getDebitiEntities().forEach(debitiEntity -> {
                    try {
                        debitiService.deleteById(debitiEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getDivertimentoEntities().isEmpty()) {
                repository.findById(id).get().getDivertimentoEntities().forEach(divertimentoEntity -> {
                    try {
                        divertimentoService.deleteById(divertimentoEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getFigliEntities().isEmpty()) {
                repository.findById(id).get().getFigliEntities().forEach(figliEntity -> {
                    try {
                        figliService.deleteById(figliEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getIstruzioneEntities().isEmpty()) {
                repository.findById(id).get().getIstruzioneEntities().forEach(istruzioneEntity -> {
                    try {
                        istruzioneService.deleteById(istruzioneEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getRegaliEntities().isEmpty()) {
                repository.findById(id).get().getRegaliEntities().forEach(regaliEntity -> {
                    try {
                        regaliService.deleteById(regaliEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getSpeseMedicheEntities().isEmpty()) {
                repository.findById(id).get().getSpeseMedicheEntities().forEach(speseMedicheEntity -> {
                    try {
                        speseMedicheService.deleteById(speseMedicheEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getSpeseQuotidianeEntities().isEmpty()) {
                repository.findById(id).get().getSpeseQuotidianeEntities().forEach(speseQuotidianeEntity -> {
                    try {
                        speseQuotidianeService.deleteById(speseQuotidianeEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getTecnologiaEntities().isEmpty()) {
                repository.findById(id).get().getTecnologiaEntities().forEach(tecnologiaEntity -> {
                    try {
                        tecnologiaService.deleteById(tecnologiaEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getTrasportiEntities().isEmpty()) {
                repository.findById(id).get().getTrasportiEntities().forEach(trasportiEntity -> {
                    try {
                        trasportiService.deleteById(trasportiEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getViaggiEntities().isEmpty()) {
                repository.findById(id).get().getViaggiEntities().forEach(viaggiEntity -> {
                    try {
                        viaggiService.deleteById(viaggiEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
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
    public Iterable<UsciteAnnualiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<UsciteAnnualiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<UsciteAnnualiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public UsciteAnnualiEntity save(UsciteAnnualiEntity entity) {
        altreUsciteService.saveAll(entity.getAltreUsciteEntities());
        animaliDomesticiService.saveAll(entity.getAnimaliDomesticiEntities());
        assicurazioneService.saveAll(entity.getAssicurazioneEntities());
        bolletteService.saveAll(entity.getBolletteEntities());
        casaService.saveAll(entity.getCasaEntities());
        debitiService.saveAll(entity.getDebitiEntities());
        divertimentoService.saveAll(entity.getDivertimentoEntities());
        figliService.saveAll(entity.getFigliEntities());
        istruzioneService.saveAll(entity.getIstruzioneEntities());
        regaliService.saveAll(entity.getRegaliEntities());
        speseMedicheService.saveAll(entity.getSpeseMedicheEntities());
        speseQuotidianeService.saveAll(entity.getSpeseQuotidianeEntities());
        tecnologiaService.saveAll(entity.getTecnologiaEntities());
        trasportiService.saveAll(entity.getTrasportiEntities());
        viaggiService.saveAll(entity.getViaggiEntities());
        return repository.save(entity);
    }

    public Iterable<UsciteAnnualiEntity> saveAll(Iterable<UsciteAnnualiEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }

    // TODO: finire di implementare i save del service divertimento
}