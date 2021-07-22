package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.BolletteEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.BolletteRepository;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.AltreBolletteService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteAcquaService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteElettricitaService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteGASService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteInternetService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteRifiutiService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteTVService;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.BolletteTelefonoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class BolletteService {
    @Autowired
    BolletteRepository repository;

    @Autowired
    AltreBolletteService altreBolletteService;

    @Autowired
    BolletteAcquaService bolletteAcquaService;

    @Autowired
    BolletteElettricitaService bolletteElettricitaService;

    @Autowired
    BolletteGASService bolletteGASService;

    @Autowired
    BolletteInternetService bolletteInternetService;

    @Autowired
    BolletteRifiutiService bolletteRifiutiService;

    @Autowired
    BolletteTelefonoService bolletteTelefonoService;

    @Autowired
    BolletteTVService bolletteTVService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(BolletteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (!entity.getAltreBolletteEntities().isEmpty()) {
                entity.getAltreBolletteEntities().forEach(altreBolletteEntity -> {
                    try {
                        altreBolletteService.delete(altreBolletteEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteAcquaEntities().isEmpty()) {
                entity.getBolletteAcquaEntities().forEach(bolletteAcquaEntity -> {
                    try {
                        bolletteAcquaService.delete(bolletteAcquaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteElettricitaEntities().isEmpty()) {
                entity.getBolletteElettricitaEntities().forEach(bolletteElettricitaEntity -> {
                    try {
                        bolletteElettricitaService.delete(bolletteElettricitaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteGASEntities().isEmpty()) {
                entity.getBolletteGASEntities().forEach(bolletteGASEntity -> {
                    try {
                        bolletteGASService.delete(bolletteGASEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteInternetEntities().isEmpty()) {
                entity.getBolletteInternetEntities().forEach(bolletteInternetEntity -> {
                    try {
                        bolletteInternetService.delete(bolletteInternetEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteRifiutiEntities().isEmpty()) {
                entity.getBolletteRifiutiEntities().forEach(bolletteRifiutiEntity -> {
                    try {
                        bolletteRifiutiService.delete(bolletteRifiutiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteTelefonoEntities().isEmpty()) {
                entity.getBolletteTelefonoEntities().forEach(bolletteTelefonoEntity -> {
                    try {
                        bolletteTelefonoService.delete(bolletteTelefonoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getBolletteTVEntities().isEmpty()) {
                entity.getBolletteTVEntities().forEach(bolletteTVEntity -> {
                    try {
                        bolletteTVService.delete(bolletteTVEntity);
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

    public void deleteAll() {
        altreBolletteService.deleteAll();
        bolletteAcquaService.deleteAll();
        bolletteElettricitaService.deleteAll();
        bolletteGASService.deleteAll();
        bolletteInternetService.deleteAll();
        bolletteRifiutiService.deleteAll();
        bolletteTelefonoService.deleteAll();
        bolletteTVService.deleteAll();
        repository.deleteAll();
    }

    public void deleteAll(Iterable<BolletteEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
        repository.deleteAll(entities);
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)||repository.findById(id).isPresent()) {
            if (!repository.findById(id).get().getAltreBolletteEntities().isEmpty()) {
                repository.findById(id).get().getAltreBolletteEntities().forEach(entity -> {
                    try {
                        altreBolletteService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteAcquaEntities().isEmpty()) {
                repository.findById(id).get().getBolletteAcquaEntities().forEach(entity -> {
                    try {
                        bolletteAcquaService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteElettricitaEntities().isEmpty()) {
                repository.findById(id).get().getBolletteElettricitaEntities().forEach(entity -> {
                    try {
                        bolletteElettricitaService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteGASEntities().isEmpty()) {
                repository.findById(id).get().getBolletteGASEntities().forEach(entity -> {
                    try {
                        bolletteGASService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteInternetEntities().isEmpty()) {
                repository.findById(id).get().getBolletteInternetEntities().forEach(entity -> {
                    try {
                        bolletteInternetService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteRifiutiEntities().isEmpty()) {
                repository.findById(id).get().getBolletteRifiutiEntities().forEach(entity -> {
                    try {
                        bolletteRifiutiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteTelefonoEntities().isEmpty()) {
                repository.findById(id).get().getBolletteTelefonoEntities().forEach(entity -> {
                    try {
                        bolletteTelefonoService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBolletteTVEntities().isEmpty()) {
                repository.findById(id).get().getBolletteTVEntities().forEach(entity -> {
                    try {
                        bolletteTVService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.deleteById(id);
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
    public Iterable<BolletteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<BolletteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<BolletteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public BolletteEntity save(BolletteEntity entity) {
        altreBolletteService.saveAll(entity.getAltreBolletteEntities());
        bolletteAcquaService.saveAll(entity.getBolletteAcquaEntities());
        bolletteElettricitaService.saveAll(entity.getBolletteElettricitaEntities());
        bolletteGASService.saveAll(entity.getBolletteGASEntities());
        bolletteInternetService.saveAll(entity.getBolletteInternetEntities());
        bolletteRifiutiService.saveAll(entity.getBolletteRifiutiEntities());
        bolletteTVService.saveAll(entity.getBolletteTVEntities());
        bolletteTelefonoService.saveAll(entity.getBolletteTelefonoEntities());
        return repository.save(entity);
    }

    public Iterable<BolletteEntity> saveAll(Iterable<BolletteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
