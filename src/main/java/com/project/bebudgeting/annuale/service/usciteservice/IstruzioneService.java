package com.project.bebudgeting.annuale.service.usciteservice;

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
            } else {
                throw new NotFoundException("Item Not Present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }
}
