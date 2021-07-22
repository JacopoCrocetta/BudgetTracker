package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.AssicurazioneRepository;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AltreAssicurazioniService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneAutoService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneSaluteService;
import com.project.bebudgeting.annuale.service.usciteservice.assicurazioneservice.AssicurazioneVitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AssicurazioneService {
    @Autowired
    AssicurazioneRepository repository;

    @Autowired
    AltreAssicurazioniService altreAssicurazioniService;

    @Autowired
    AssicurazioneAutoService assicurazioneAutoService;

    @Autowired
    AssicurazioneCasaService assicurazioneCasaService;

    @Autowired
    AssicurazioneSaluteService assicurazioneSaluteService;

    @Autowired
    AssicurazioneVitaService assicurazioneVitaService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AssicurazioneEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (!entity.getAltreAssicurazioniEntities().isEmpty()) {
                entity.getAltreAssicurazioniEntities().forEach(assicurazioneEntity -> {
                    try {
                        altreAssicurazioniService.delete(assicurazioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getAssicurazioneAutoEntities().isEmpty()) {
                entity.getAssicurazioneAutoEntities().forEach(assicurazioneEntity -> {
                    try {
                        assicurazioneAutoService.delete(assicurazioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getAssicurazioneCasaEntities().isEmpty()) {
                entity.getAssicurazioneCasaEntities().forEach(assicurazioneEntity -> {
                    try {
                        assicurazioneCasaService.delete(assicurazioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getAssicurazioneSaluteEntities().isEmpty()) {
                entity.getAssicurazioneSaluteEntities().forEach(assicurazioneEntity -> {
                    try {
                        assicurazioneSaluteService.delete(assicurazioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getAssicurazioneVitaEntities().isEmpty()) {
                entity.getAssicurazioneVitaEntities().forEach(assicurazioneEntity -> {
                    try {
                        assicurazioneVitaService.delete(assicurazioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AssicurazioneEntity> entities) {
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
            if (!repository.findById(id).get().getAltreAssicurazioniEntities().isEmpty()) {
                repository.findById(id).get().getAltreAssicurazioniEntities().forEach(entity -> {
                    try {
                        altreAssicurazioniService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAssicurazioneAutoEntities().isEmpty()) {
                repository.findById(id).get().getAssicurazioneAutoEntities().forEach(entity -> {
                    try {
                        assicurazioneAutoService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAssicurazioneCasaEntities().isEmpty()) {
                repository.findById(id).get().getAssicurazioneCasaEntities().forEach(entity -> {
                    try {
                        assicurazioneCasaService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAssicurazioneSaluteEntities().isEmpty()) {
                repository.findById(id).get().getAssicurazioneSaluteEntities().forEach(entity -> {
                    try {
                        assicurazioneSaluteService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAssicurazioneVitaEntities().isEmpty()) {
                repository.findById(id).get().getAssicurazioneVitaEntities().forEach(entity -> {
                    try {
                        assicurazioneVitaService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.deleteById(id);
            }
        } else {
            throw new NotFoundException("Item Not Found");
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
    public Iterable<AssicurazioneEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AssicurazioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AssicurazioneEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AssicurazioneEntity save(AssicurazioneEntity entity) {
        return repository.save(entity);
    }

    public Iterable<AssicurazioneEntity> saveAll(Iterable<AssicurazioneEntity> entities) {
        return repository.saveAll(entities);
    }
}
