package com.project.bebudgeting.annuale.service.usciteservice;

import com.project.bebudgeting.annuale.repository.usciteannuali.BolletteRepository;
import com.project.bebudgeting.annuale.service.usciteservice.bolletteservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public long count(){
        return repository.count();
    }

    //DELETE
    public void deleteAll(){
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
}
