package com.project.bebudgeting.service.mensili.previsti;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.UscitePrevisteEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.UscitePrevisteRepository;
import com.project.bebudgeting.service.mensili.previsti.uscite.AlimentiPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.uscite.AltreUscitePrevisteService;
import com.project.bebudgeting.service.mensili.previsti.uscite.AnimaliDomesticiPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.uscite.BollettePrevisteService;
import com.project.bebudgeting.service.mensili.previsti.uscite.CasaPrevisteService;
import com.project.bebudgeting.service.mensili.previsti.uscite.DebitiPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.uscite.RegaliPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.uscite.SpeseMedichePrevisteService;
import com.project.bebudgeting.service.mensili.previsti.uscite.SpesePersonaliPrevisteService;
import com.project.bebudgeting.service.mensili.previsti.uscite.TrasportiPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.uscite.ViaggiPrevistiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class UscitePrevisteService {
    @Autowired
    UscitePrevisteRepository repository;

    @Autowired
    AlimentiPrevistiService alimentiPrevistiService;

    @Autowired
    AltreUscitePrevisteService altreUscitePrevisteService;

    @Autowired
    AnimaliDomesticiPrevistiService animaliDomesticiPrevistiService;

    @Autowired
    BollettePrevisteService bollettePrevisteService;

    @Autowired
    CasaPrevisteService casaPrevisteService;

    @Autowired
    DebitiPrevistiService debitiPrevistiService;

    @Autowired
    RegaliPrevistiService regaliPrevistiService;

    @Autowired
    SpeseMedichePrevisteService speseMedichePrevisteService;

    @Autowired
    SpesePersonaliPrevisteService spesePersonaliPrevisteService;

    @Autowired
    TrasportiPrevistiService trasportiPrevistiService;

    @Autowired
    ViaggiPrevistiService viaggiPrevistiService;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        alimentiPrevistiService.deleteAll();
        altreUscitePrevisteService.deleteAll();
        animaliDomesticiPrevistiService.deleteAll();
        bollettePrevisteService.deleteAll();
        casaPrevisteService.deleteAll();
        debitiPrevistiService.deleteAll();
        regaliPrevistiService.deleteAll();
        speseMedichePrevisteService.deleteAll();
        spesePersonaliPrevisteService.deleteAll();
        trasportiPrevistiService.deleteAll();
        viaggiPrevistiService.deleteAll();
        repository.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    public void delete(UscitePrevisteEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent()) {
            entity.getAlimentiPrevistiEntities().forEach(alimentiEntity -> {
                if (alimentiPrevistiService.findById(alimentiEntity.getId()).isPresent()) {
                    try {
                        alimentiPrevistiService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getAltreUscitePrevisteEntities().forEach(altreUsciteEntity -> {
                if (altreUscitePrevisteService.findById(altreUsciteEntity.getId()).isPresent()) {
                    try {
                        altreUscitePrevisteService.delete(altreUsciteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getAnimaliDomesticiPrevisteEntities().forEach(animaliDomesticiEntity -> {
                if (animaliDomesticiPrevistiService.findById(animaliDomesticiEntity.getId()).isPresent()) {
                    try {
                        animaliDomesticiPrevistiService.delete(animaliDomesticiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBollettePrevisteEntities().forEach(bolletteEntity -> {
                if (bollettePrevisteService.findById(bolletteEntity.getId()).isPresent()) {
                    try {
                        bollettePrevisteService.delete(bolletteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getCasaPrevisteEntities().forEach(casaEntity -> {
                if (casaPrevisteService.findById(casaEntity.getId()).isPresent()) {
                    try {
                        casaPrevisteService.delete(casaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getDebitiPrevisteEntities().forEach(debitiEntity -> {
                if (debitiPrevistiService.findById(debitiEntity.getId()).isPresent()) {
                    try {
                        debitiPrevistiService.delete(debitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getRegaliPrevistiEntities().forEach(regaliEntity -> {
                if (regaliPrevistiService.findById(regaliEntity.getId()).isPresent()) {
                    try {
                        regaliPrevistiService.delete(regaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getSpeseMedichePrevistiEntities().forEach(speseMedicheEntity -> {
                if (speseMedichePrevisteService.findById(speseMedicheEntity.getId()).isPresent()) {
                    try {
                        speseMedichePrevisteService.delete(speseMedicheEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getSpesePersonaliPrevistiEntities().forEach(spesePersonaliEntity -> {
                if (spesePersonaliPrevisteService.findById(spesePersonaliEntity.getId()).isPresent()) {
                    try {
                        spesePersonaliPrevisteService.delete(spesePersonaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getTrasportiPrevistiEntities().forEach(trasportiEntity -> {
                if (trasportiPrevistiService.findById(trasportiEntity.getId()).isPresent()) {
                    try {
                        trasportiPrevistiService.delete(trasportiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getViaggiPrevistiEntities().forEach(viaggiEntity -> {
                if (viaggiPrevistiService.findById(viaggiEntity.getId()).isPresent()) {
                    try {
                        viaggiPrevistiService.delete(viaggiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.findById(id).isPresent()) {
            repository.findById(id).get().getAlimentiPrevistiEntities().forEach(alimentiEntity -> {
                if (alimentiPrevistiService.findById(alimentiEntity.getId()).isPresent()) {
                    try {
                        alimentiPrevistiService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getAltreUscitePrevisteEntities().forEach(altreUsciteEntity -> {
                if (altreUscitePrevisteService.findById(altreUsciteEntity.getId()).isPresent()) {
                    try {
                        altreUscitePrevisteService.delete(altreUsciteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getAnimaliDomesticiPrevisteEntities().forEach(animaliDomesticiEntity -> {
                if (animaliDomesticiPrevistiService.findById(animaliDomesticiEntity.getId()).isPresent()) {
                    try {
                        animaliDomesticiPrevistiService.delete(animaliDomesticiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBollettePrevisteEntities().forEach(bolletteEntity -> {
                if (bollettePrevisteService.findById(bolletteEntity.getId()).isPresent()) {
                    try {
                        bollettePrevisteService.delete(bolletteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getCasaPrevisteEntities().forEach(casaEntity -> {
                if (casaPrevisteService.findById(casaEntity.getId()).isPresent()) {
                    try {
                        casaPrevisteService.delete(casaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getDebitiPrevisteEntities().forEach(debitiEntity -> {
                if (debitiPrevistiService.findById(debitiEntity.getId()).isPresent()) {
                    try {
                        debitiPrevistiService.delete(debitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getRegaliPrevistiEntities().forEach(regaliEntity -> {
                if (regaliPrevistiService.findById(regaliEntity.getId()).isPresent()) {
                    try {
                        regaliPrevistiService.delete(regaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getSpeseMedichePrevistiEntities().forEach(speseMedicheEntity -> {
                if (speseMedichePrevisteService.findById(speseMedicheEntity.getId()).isPresent()) {
                    try {
                        speseMedichePrevisteService.delete(speseMedicheEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getSpesePersonaliPrevistiEntities().forEach(spesePersonaliEntity -> {
                if (spesePersonaliPrevisteService.findById(spesePersonaliEntity.getId()).isPresent()) {
                    try {
                        spesePersonaliPrevisteService.delete(spesePersonaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getTrasportiPrevistiEntities().forEach(trasportiEntity -> {
                if (trasportiPrevistiService.findById(trasportiEntity.getId()).isPresent()) {
                    try {
                        trasportiPrevistiService.delete(trasportiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getViaggiPrevistiEntities().forEach(viaggiEntity -> {
                if (viaggiPrevistiService.findById(viaggiEntity.getId()).isPresent()) {
                    try {
                        viaggiPrevistiService.delete(viaggiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    /**
     * @param entities
     */
    public void deleteAll(Iterable<UscitePrevisteEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
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
     * @return Iterable<UscitePrevisteEntity>
     */
    // FIND
    public Iterable<UscitePrevisteEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<UscitePrevisteEntity>
     */
    public Iterable<UscitePrevisteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<UscitePrevisteEntity>
     */
    public Optional<UscitePrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return UscitePrevisteEntity
     */
    // SAVE
    public UscitePrevisteEntity save(UscitePrevisteEntity entity) {
        alimentiPrevistiService.saveAll(entity.getAlimentiPrevistiEntities());
        altreUscitePrevisteService.saveAll(entity.getAltreUscitePrevisteEntities());
        animaliDomesticiPrevistiService.saveAll(entity.getAnimaliDomesticiPrevisteEntities());
        bollettePrevisteService.saveAll(entity.getBollettePrevisteEntities());
        casaPrevisteService.saveAll(entity.getCasaPrevisteEntities());
        debitiPrevistiService.saveAll(entity.getDebitiPrevisteEntities());
        regaliPrevistiService.saveAll(entity.getRegaliPrevistiEntities());
        speseMedichePrevisteService.saveAll(entity.getSpeseMedichePrevistiEntities());
        spesePersonaliPrevisteService.saveAll(entity.getSpesePersonaliPrevistiEntities());
        trasportiPrevistiService.saveAll(entity.getTrasportiPrevistiEntities());
        viaggiPrevistiService.saveAll(entity.getViaggiPrevistiEntities());
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<UscitePrevisteEntity>
     */
    public Iterable<UscitePrevisteEntity> saveAll(Iterable<UscitePrevisteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
