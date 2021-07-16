package com.project.bebudgeting.annuale.service.entrateservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.SalarioRepository;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.AltroSalarioService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.BonusService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.BustaPagaService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.CommissioniService;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.ManceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalarioService {
    @Autowired
    SalarioRepository repository;

    @Autowired
    AltroSalarioService altroSalarioService;

    @Autowired
    BonusService bonusService;

    @Autowired
    BustaPagaService bustaPagaService;

    @Autowired
    CommissioniService commissioniService;

    @Autowired
    ManceService mancheService;

    public long count() {
        return repository.count();
    }

    // FIND
    public Iterable<SalarioEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<SalarioEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<SalarioEntity> findById(int id) {
        return repository.findById(id);
    }

    // DELETE
    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<SalarioEntity> entities) {
        // da definire
    }

    public void deleteAllById(Iterable<Integer> ids) {
        // da definire
    }

    public void delete(SalarioEntity entityToDelete) {
        // da definire
    }

    // SAVE
    public SalarioEntity save(SalarioEntity entityToSave) {
        return repository.save(entityToSave);
    }

    public Iterable<SalarioEntity> saveAll(Iterable<SalarioEntity> entitiesToSave) {
        return repository.saveAll(entitiesToSave);
    }
}
