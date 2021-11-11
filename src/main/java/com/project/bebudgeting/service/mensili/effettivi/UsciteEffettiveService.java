package com.project.bebudgeting.service.mensili.effettivi;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.UsciteEffettiveEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.UsciteEffettiveRepository;
import com.project.bebudgeting.service.mensili.effettivi.uscite.AlimentiEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.AltreUsciteEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.AnimaliDomesticiEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.BolletteEffettiveService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.CasaEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.DebitiEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.RegaliEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.SpeseMedicheEffettiveService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.SpesePersonaliEffettiveService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.TrasportiEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.uscite.ViaggiEffettiviService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class UsciteEffettiveService {
    @Autowired
    UsciteEffettiveRepository repository;

    @Autowired
    AlimentiEffettiviService alimentiEffettiviService;

    @Autowired
    AltreUsciteEffettiviService altreUsciteEffettiviService;

    @Autowired
    AnimaliDomesticiEffettiviService animaliDomesticiEffettiviService;

    @Autowired
    BolletteEffettiveService bolletteEffettiveService;

    @Autowired
    CasaEffettiviService casaEffettiviService;

    @Autowired
    DebitiEffettiviService debitiEffettiviService;

    @Autowired
    RegaliEffettiviService regaliEffettiviService;

    @Autowired
    SpeseMedicheEffettiveService speseMedicheEffettiveService;

    @Autowired
    SpesePersonaliEffettiveService spesePersonaliEffettiveService;

    @Autowired
    TrasportiEffettiviService trasportiEffettiviService;

    @Autowired
    ViaggiEffettiviService viaggiEffettiviService;

    /**
     * @return long
     */
    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        alimentiEffettiviService.deleteAll();
        altreUsciteEffettiviService.deleteAll();
        animaliDomesticiEffettiviService.deleteAll();
        bolletteEffettiveService.deleteAll();
        casaEffettiviService.deleteAll();
        debitiEffettiviService.deleteAll();
        regaliEffettiviService.deleteAll();
        speseMedicheEffettiveService.deleteAll();
        spesePersonaliEffettiveService.deleteAll();
        trasportiEffettiviService.deleteAll();
        viaggiEffettiviService.deleteAll();
        repository.deleteAll();
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    public void delete(UsciteEffettiveEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent()) {
            entity.getAlimentiEffettiviEntities().forEach(alimentiEntity -> {
                if (alimentiEffettiviService.findById(alimentiEntity.getId()).isPresent()) {
                    try {
                        alimentiEffettiviService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getAltreUsciteEffettiveEntities().forEach(altreUsciteEntity -> {
                if (altreUsciteEffettiviService.findById(altreUsciteEntity.getId()).isPresent()) {
                    try {
                        altreUsciteEffettiviService.delete(altreUsciteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getAnimaliDomesticiEffettiviEntities().forEach(animaliDomesticiEntity -> {
                if (animaliDomesticiEffettiviService.findById(animaliDomesticiEntity.getId()).isPresent()) {
                    try {
                        animaliDomesticiEffettiviService.delete(animaliDomesticiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBolletteEffettiviEntities().forEach(bolletteEntity -> {
                if (bolletteEffettiveService.findById(bolletteEntity.getId()).isPresent()) {
                    try {
                        bolletteEffettiveService.delete(bolletteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getCasaEffettiviEntities().forEach(casaEntity -> {
                if (casaEffettiviService.findById(casaEntity.getId()).isPresent()) {
                    try {
                        casaEffettiviService.delete(casaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getDebitiEffettiviEntities().forEach(debitiEntity -> {
                if (debitiEffettiviService.findById(debitiEntity.getId()).isPresent()) {
                    try {
                        debitiEffettiviService.delete(debitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getRegaliEffettiviEntities().forEach(regaliEntity -> {
                if (regaliEffettiviService.findById(regaliEntity.getId()).isPresent()) {
                    try {
                        regaliEffettiviService.delete(regaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getSpeseMedicheEffettiviEntities().forEach(speseMedicheEntity -> {
                if (speseMedicheEffettiveService.findById(speseMedicheEntity.getId()).isPresent()) {
                    try {
                        speseMedicheEffettiveService.delete(speseMedicheEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getSpesePersonaliEffettiviEntities().forEach(spesePersonaliEntity -> {
                if (spesePersonaliEffettiveService.findById(spesePersonaliEntity.getId()).isPresent()) {
                    try {
                        spesePersonaliEffettiveService.delete(spesePersonaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getTrasportiEffettiviEntities().forEach(trasportiEntity -> {
                if (trasportiEffettiviService.findById(trasportiEntity.getId()).isPresent()) {
                    try {
                        trasportiEffettiviService.delete(trasportiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getViaggiEffettiviEntities().forEach(viaggiEntity -> {
                if (viaggiEffettiviService.findById(viaggiEntity.getId()).isPresent()) {
                    try {
                        viaggiEffettiviService.delete(viaggiEntity);
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
            repository.findById(id).get().getAlimentiEffettiviEntities().forEach(alimentiEntity -> {
                if (alimentiEffettiviService.findById(alimentiEntity.getId()).isPresent()) {
                    try {
                        alimentiEffettiviService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getAltreUsciteEffettiveEntities().forEach(altreUsciteEntity -> {
                if (altreUsciteEffettiviService.findById(altreUsciteEntity.getId()).isPresent()) {
                    try {
                        altreUsciteEffettiviService.delete(altreUsciteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getAnimaliDomesticiEffettiviEntities().forEach(animaliDomesticiEntity -> {
                if (animaliDomesticiEffettiviService.findById(animaliDomesticiEntity.getId()).isPresent()) {
                    try {
                        animaliDomesticiEffettiviService.delete(animaliDomesticiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBolletteEffettiviEntities().forEach(bolletteEntity -> {
                if (bolletteEffettiveService.findById(bolletteEntity.getId()).isPresent()) {
                    try {
                        bolletteEffettiveService.delete(bolletteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getCasaEffettiviEntities().forEach(casaEntity -> {
                if (casaEffettiviService.findById(casaEntity.getId()).isPresent()) {
                    try {
                        casaEffettiviService.delete(casaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getDebitiEffettiviEntities().forEach(debitiEntity -> {
                if (debitiEffettiviService.findById(debitiEntity.getId()).isPresent()) {
                    try {
                        debitiEffettiviService.delete(debitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getRegaliEffettiviEntities().forEach(regaliEntity -> {
                if (regaliEffettiviService.findById(regaliEntity.getId()).isPresent()) {
                    try {
                        regaliEffettiviService.delete(regaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getSpeseMedicheEffettiviEntities().forEach(speseMedicheEntity -> {
                if (speseMedicheEffettiveService.findById(speseMedicheEntity.getId()).isPresent()) {
                    try {
                        speseMedicheEffettiveService.delete(speseMedicheEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getSpesePersonaliEffettiviEntities().forEach(spesePersonaliEntity -> {
                if (spesePersonaliEffettiveService.findById(spesePersonaliEntity.getId()).isPresent()) {
                    try {
                        spesePersonaliEffettiveService.delete(spesePersonaliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getTrasportiEffettiviEntities().forEach(trasportiEntity -> {
                if (trasportiEffettiviService.findById(trasportiEntity.getId()).isPresent()) {
                    try {
                        trasportiEffettiviService.delete(trasportiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getViaggiEffettiviEntities().forEach(viaggiEntity -> {
                if (viaggiEffettiviService.findById(viaggiEntity.getId()).isPresent()) {
                    try {
                        viaggiEffettiviService.delete(viaggiEntity);
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
    public void deleteAll(Iterable<UsciteEffettiveEntity> entities) {
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
     * @return Iterable<UsciteEffettiveEntity>
     */
    // FIND
    public Iterable<UsciteEffettiveEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<UsciteEffettiveEntity>
     */
    public Iterable<UsciteEffettiveEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<UsciteEffettiveEntity>
     */
    public Optional<UsciteEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return UsciteEffettiveEntity
     */
    // SAVE
    public UsciteEffettiveEntity save(UsciteEffettiveEntity entity) {
        alimentiEffettiviService.saveAll(entity.getAlimentiEffettiviEntities());
        altreUsciteEffettiviService.saveAll(entity.getAltreUsciteEffettiveEntities());
        animaliDomesticiEffettiviService.saveAll(entity.getAnimaliDomesticiEffettiviEntities());
        bolletteEffettiveService.saveAll(entity.getBolletteEffettiviEntities());
        casaEffettiviService.saveAll(entity.getCasaEffettiviEntities());
        debitiEffettiviService.saveAll(entity.getDebitiEffettiviEntities());
        regaliEffettiviService.saveAll(entity.getRegaliEffettiviEntities());
        speseMedicheEffettiveService.saveAll(entity.getSpeseMedicheEffettiviEntities());
        spesePersonaliEffettiveService.saveAll(entity.getSpesePersonaliEffettiviEntities());
        trasportiEffettiviService.saveAll(entity.getTrasportiEffettiviEntities());
        viaggiEffettiviService.saveAll(entity.getViaggiEffettiviEntities());
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<UsciteEffettiveEntity>
     */
    public Iterable<UsciteEffettiveEntity> saveAll(Iterable<UsciteEffettiveEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
