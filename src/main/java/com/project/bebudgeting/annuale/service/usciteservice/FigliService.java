package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.FigliEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.FigliRepository;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.AltroFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.AsiloService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.AttivitaFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.GiocattoliFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.PaghettaFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.ScuolaFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.SpeseMedicheFigliService;
import com.project.bebudgeting.annuale.service.usciteservice.figliservice.VestitiFigliService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FigliService {
    @Autowired
    FigliRepository repository;

    @Autowired
    AltroFigliService altroFigliService;

    @Autowired
    AsiloService asiloService;

    @Autowired
    AttivitaFigliService attivitaFigliService;

    @Autowired
    GiocattoliFigliService giocattoliService;

    @Autowired
    PaghettaFigliService paghettaFigliService;

    @Autowired
    ScuolaFigliService scuolaFigliService;

    @Autowired
    SpeseMedicheFigliService speseMedicheFigliService;

    @Autowired
    VestitiFigliService vestitiFigliService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroFigliService.deleteAll();
        asiloService.deleteAll();
        attivitaFigliService.deleteAll();
        giocattoliService.deleteAll();
        paghettaFigliService.deleteAll();
        scuolaFigliService.deleteAll();
        speseMedicheFigliService.deleteAll();
        vestitiFigliService.deleteAll();
        repository.deleteAll();
    }

    public void delete(FigliEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (repository.findById(entity.getId()).isPresent()) {
                repository.findById(entity.getId()).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroFigliService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getAsiloEntities().forEach(asiloEntity -> {
                    try {
                        asiloService.delete(asiloEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getAttivitaEntities().forEach(attivitaFilgliEntity -> {
                    try {
                        attivitaFigliService.delete(attivitaFilgliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getGiocattoliEntities().forEach(giocattoliEntity -> {
                    try {
                        giocattoliService.delete(giocattoliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getPaghettaEntities().forEach(paghettaEntity -> {
                    try {
                        paghettaFigliService.delete(paghettaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getScuolaEntities().forEach(scuolaEntity -> {
                    try {
                        scuolaFigliService.delete(scuolaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getSpeseMedicheFigliEntities().forEach(speseMedicheEntity -> {
                    try {
                        speseMedicheFigliService.delete(speseMedicheEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(entity.getId()).get().getVestitiEntities().forEach(vestitiEntity -> {
                    try {
                        vestitiFigliService.delete(vestitiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                throw new NotFoundException("Item not present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<FigliEntity> entities) {
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
            if (repository.findById(id).isPresent()) {
                repository.findById(id).get().getAltroEntities().forEach(entity -> {
                    try {
                        altroFigliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getAsiloEntities().forEach(entity -> {
                    try {
                        asiloService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getAttivitaEntities().forEach(entity -> {
                    try {
                        attivitaFigliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getGiocattoliEntities().forEach(entity -> {
                    try {
                        giocattoliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getPaghettaEntities().forEach(entity -> {
                    try {
                        paghettaFigliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getScuolaEntities().forEach(entity -> {
                    try {
                        scuolaFigliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getSpeseMedicheFigliEntities().forEach(entity -> {
                    try {
                        speseMedicheFigliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.findById(id).get().getVestitiEntities().forEach(entity -> {
                    try {
                        vestitiFigliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                throw new NotFoundException("Item not present");
            }
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
    public Iterable<FigliEntity> finAll() {
        return repository.findAll();
    }

    public Iterable<FigliEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<FigliEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public FigliEntity save(FigliEntity entity) {
        altroFigliService.saveAll(entity.getAltroEntities());
        asiloService.saveAll(entity.getAsiloEntities());
        attivitaFigliService.saveAll(entity.getAttivitaEntities());
        giocattoliService.saveAll(entity.getGiocattoliEntities());
        paghettaFigliService.saveAll(entity.getPaghettaEntities());
        scuolaFigliService.saveAll(entity.getScuolaEntities());
        speseMedicheFigliService.saveAll(entity.getSpeseMedicheFigliEntities());
        vestitiFigliService.saveAll(entity.getVestitiEntities());
        return repository.save(entity);
    }

    public Iterable<FigliEntity> saveAll(Iterable<FigliEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
