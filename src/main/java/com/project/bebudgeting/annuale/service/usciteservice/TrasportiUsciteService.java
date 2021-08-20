package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.TrasportiUsciteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.TrasportiUsciteRepository;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.AltroTrasportiService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.BolloService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.CarburanteService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.FornitureTrasportiService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.PrestitoAutoService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.RiparazioniService;
import com.project.bebudgeting.annuale.service.usciteservice.trasportiservice.TrasportoPubblicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class TrasportiUsciteService {
    @Autowired
    TrasportiUsciteRepository repository;

    @Autowired
    AltroTrasportiService altroTrasportiService;

    @Autowired
    BolloService bolloService;

    @Autowired
    CarburanteService carburanteService;

    @Autowired
    FornitureTrasportiService fornitureService;

    @Autowired
    PrestitoAutoService prestitoAutoService;

    @Autowired
    RiparazioniService riparazioniService;

    @Autowired
    TrasportoPubblicoService trasportoPubblicoService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroTrasportiService.deleteAll();
        bolloService.deleteAll();
        carburanteService.deleteAll();
        fornitureService.deleteAll();
        prestitoAutoService.deleteAll();
        riparazioniService.deleteAll();
        trasportoPubblicoService.deleteAll();
        repository.deleteAll();
    }

    public void delete(TrasportiUsciteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId()) || repository.findById(entity.getId()).isPresent()) {
            if (!repository.findById(entity.getId()).get().getAltroEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroTrasportiService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getBolloEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getBolloEntities().forEach(bolloEntity -> {
                    try {
                        bolloService.delete(bolloEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getCarburanteEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getCarburanteEntities().forEach(carburanteEntity -> {
                    try {
                        carburanteService.delete(carburanteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getFornitureEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getFornitureEntities().forEach(fornitureEntity -> {
                    try {
                        fornitureService.delete(fornitureEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getPrestitoAutoEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getPrestitoAutoEntities().forEach(prestitoEntity -> {
                    try {
                        prestitoAutoService.delete(prestitoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getRiparazioniEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getRiparazioniEntities().forEach(riparazioniEntity -> {
                    try {
                        riparazioniService.delete(riparazioniEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getTrasportoPubblicoEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getTrasportoPubblicoEntities().forEach(trasportoEntity -> {
                    try {
                        trasportoPubblicoService.delete(trasportoEntity);
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

    public void deleteAll(Iterable<TrasportiUsciteEntity> entities) {
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
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroTrasportiService.deleteById(altroEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolloEntities().isEmpty()) {
                repository.findById(id).get().getBolloEntities().forEach(bolloEntity -> {
                    try {
                        bolloService.deleteById(bolloEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getCarburanteEntities().isEmpty()) {
                repository.findById(id).get().getCarburanteEntities().forEach(carburanteEntity -> {
                    try {
                        carburanteService.deleteById(carburanteEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getFornitureEntities().isEmpty()) {
                repository.findById(id).get().getFornitureEntities().forEach(fornitureEntity -> {
                    try {
                        fornitureService.deleteById(fornitureEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getPrestitoAutoEntities().isEmpty()) {
                repository.findById(id).get().getPrestitoAutoEntities().forEach(prestitoEntity -> {
                    try {
                        prestitoAutoService.deleteById(prestitoEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getRiparazioniEntities().isEmpty()) {
                repository.findById(id).get().getRiparazioniEntities().forEach(riparazioniEntity -> {
                    try {
                        riparazioniService.deleteById(riparazioniEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getTrasportoPubblicoEntities().isEmpty()) {
                repository.findById(id).get().getTrasportoPubblicoEntities().forEach(trasportoEntity -> {
                    try {
                        trasportoPubblicoService.deleteById(trasportoEntity.getId());
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
    public Iterable<TrasportiUsciteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<TrasportiUsciteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<TrasportiUsciteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public TrasportiUsciteEntity save(TrasportiUsciteEntity entity) {
        altroTrasportiService.saveAll(entity.getAltroEntities());
        bolloService.saveAll(entity.getBolloEntities());
        carburanteService.saveAll(entity.getCarburanteEntities());
        fornitureService.saveAll(entity.getFornitureEntities());
        prestitoAutoService.saveAll(entity.getPrestitoAutoEntities());
        riparazioniService.saveAll(entity.getRiparazioniEntities());
        trasportoPubblicoService.saveAll(entity.getTrasportoPubblicoEntities());
        return repository.save(entity);
    }

    public Iterable<TrasportiUsciteEntity> saveAll(Iterable<TrasportiUsciteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
