package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.IstruzioneEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.IstruzioneRepository;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.AltroIstruzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.LezioniIndipendentiService;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.LibriService;
import com.project.bebudgeting.annuale.service.usciteservice.istruzioneservice.RetteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class IstruzioneService {
    @Autowired
    IstruzioneRepository repository;

    @Autowired
    AltroIstruzioneService altroIstruzioneService;

    @Autowired
    LezioniIndipendentiService lezioniIndipendentiService;

    @Autowired
    LibriService libriService;

    @Autowired
    RetteService retteService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroIstruzioneService.deleteAll();
        lezioniIndipendentiService.deleteAll();
        libriService.deleteAll();
        retteService.deleteAll();
        repository.deleteAll();
    }

    public void delete(IstruzioneEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (repository.findById(entity.getId()).isPresent()) {
                entity.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroIstruzioneService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                entity.getLezioniIndipendentiEntities().forEach(lezioniIndipendentiEntity -> {
                    try {
                        lezioniIndipendentiService.delete(lezioniIndipendentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                entity.getLibriEntities().forEach(libriEntity -> {
                    try {
                        libriService.delete(libriEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                entity.getRetteEntities().forEach(retteEntity -> {
                    try {
                        retteService.delete(retteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
                repository.delete(entity);
            } else {
                throw new NotFoundException("Item Not Present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<IstruzioneEntity> entities) {
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
                if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                    repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                        try {
                            altroIstruzioneService.deleteById(altroEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getLezioniIndipendentiEntities().isEmpty()) {
                    repository.findById(id).get().getLezioniIndipendentiEntities().forEach(lezioniEntity -> {
                        try {
                            lezioniIndipendentiService.deleteById(lezioniEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getLibriEntities().isEmpty()) {
                    repository.findById(id).get().getLibriEntities().forEach(libriEntity -> {
                        try {
                            libriService.deleteById(libriEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getRetteEntities().isEmpty()) {
                    repository.findById(id).get().getRetteEntities().forEach(retteEntity -> {
                        try {
                            retteService.deleteById(retteEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                repository.deleteById(id);
            } else {
                throw new NotFoundException("Item not present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    // FIND
    public Iterable<IstruzioneEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<IstruzioneEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<IstruzioneEntity> findbyId(int id) {
        return repository.findById(id);
    }

    // SAVE
    public IstruzioneEntity save(IstruzioneEntity entity) {
        altroIstruzioneService.saveAll(entity.getAltroEntities());
        lezioniIndipendentiService.saveAll(entity.getLezioniIndipendentiEntities());
        libriService.saveAll(entity.getLibriEntities());
        retteService.saveAll(entity.getRetteEntities());
        return repository.save(entity);
    }

    public Iterable<IstruzioneEntity> saveAll(Iterable<IstruzioneEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
