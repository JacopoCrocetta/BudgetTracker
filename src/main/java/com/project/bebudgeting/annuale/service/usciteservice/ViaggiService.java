package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.ViaggiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.ViaggiRepository;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.AlimentiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.AltroViaggiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.BigliettiAereiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.DivertimentoService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.HotelService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.TrasportiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class ViaggiService {
    @Autowired
    ViaggiRepository repository;

    @Autowired
    AlimentiService alimentiService;

    @Autowired
    AltroViaggiService altroViaggiService;

    @Autowired
    BigliettiAereiService bigliettiAereiService;

    @Autowired
    DivertimentoService divertimentoService;

    @Autowired
    HotelService hotelService;

    @Autowired
    TrasportiService trasportiService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        alimentiService.deleteAll();
        altroViaggiService.deleteAll();
        bigliettiAereiService.deleteAll();
        divertimentoService.deleteAll();
        hotelService.deleteAll();
        trasportiService.deleteAll();
        repository.deleteAll();
    }

    public void delete(ViaggiEntity entity) throws NotFoundException {
        if (repository.findById(entity.getId()).isPresent() || !repository.findById(entity.getId()).isEmpty()) {
            if (!repository.findById(entity.getId()).get().getAlimentiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAlimentiEntities().forEach(alimentiEntity -> {
                    try {
                        alimentiService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(entity.getId()).get().getAltroEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroViaggiService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getBigliettiAereiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getBigliettiAereiEntities().forEach(bigliettiEntity -> {
                    try {
                        bigliettiAereiService.delete(bigliettiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(entity.getId()).get().getDivertimentoEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getDivertimentoEntities().forEach(divertimentoEntity -> {
                    try {
                        divertimentoService.delete(divertimentoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(entity.getId()).get().getHotelEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getHotelEntities().forEach(hotelEntity -> {
                    try {
                        hotelService.delete(hotelEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(entity.getId()).get().getTrasportiEntities().isEmpty()) {
                repository.findById(entity.getId()).get().getTrasportiEntities().forEach(trasportiEntity -> {
                    try {
                        trasportiService.delete(trasportiEntity);
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

    public void deleteAll(Iterable<ViaggiEntity> entities) {
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
            if (!repository.findById(id).get().getAlimentiEntities().isEmpty()) {
                repository.findById(id).get().getAlimentiEntities().forEach(alimentiEntity -> {
                    try {
                        alimentiService.deleteById(alimentiEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroViaggiService.deleteById(altroEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBigliettiAereiEntities().isEmpty()) {
                repository.findById(id).get().getBigliettiAereiEntities().forEach(bigliettiEntity -> {
                    try {
                        bigliettiAereiService.deleteById(bigliettiEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(id).get().getDivertimentoEntities().isEmpty()) {
                repository.findById(id).get().getDivertimentoEntities().forEach(divertimentoEntity -> {
                    try {
                        divertimentoService.deleteById(divertimentoEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getHotelEntities().isEmpty()) {
                repository.findById(id).get().getHotelEntities().forEach(hotelEntity -> {
                    try {
                        hotelService.deleteById(hotelEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (repository.findById(id).get().getTrasportiEntities().isEmpty()) {
                repository.findById(id).get().getTrasportiEntities().forEach(trasportiEntity -> {
                    try {
                        trasportiService.deleteById(trasportiEntity.getId());
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
    public Iterable<ViaggiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<ViaggiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<ViaggiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public ViaggiEntity save(ViaggiEntity entity) {
        alimentiService.saveAll(entity.getAlimentiEntities());
        altroViaggiService.saveAll(entity.getAltroEntities());
        bigliettiAereiService.saveAll(entity.getBigliettiAereiEntities());
        divertimentoService.saveAll(entity.getDivertimentoEntities());
        hotelService.saveAll(entity.getHotelEntities());
        trasportiService.saveAll(entity.getTrasportiEntities());
        return repository.save(entity);
    }

    public Iterable<ViaggiEntity> saveAll(Iterable<ViaggiEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
