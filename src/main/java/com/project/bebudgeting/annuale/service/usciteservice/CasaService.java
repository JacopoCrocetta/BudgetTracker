package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.CasaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.CasaRepository;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.AffittoService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.AltroCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.ArredamentoService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.FornitureService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.ManutenzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.MiglioramentiService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.TraslocoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CasaService {
    @Autowired
    CasaRepository repository;

    @Autowired
    AffittoService affittoService;

    @Autowired
    AltroCasaService altroCasaService;

    @Autowired
    ArredamentoService arredamentoService;

    @Autowired
    FornitureService fornitureService;

    @Autowired
    ManutenzioneService manutenzioneService;

    @Autowired
    MiglioramentiService miglioramentiService;

    @Autowired
    TraslocoService traslocoService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(CasaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (!entity.getAffittoEntities().isEmpty()) {
                entity.getAffittoEntities().forEach(affittoEntity -> {
                    try {
                        affittoService.delete(affittoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getAltroEntities().isEmpty()) {
                entity.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroCasaService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getArredamentoEntities().isEmpty()) {
                entity.getArredamentoEntities().forEach(arredamentoEntity -> {
                    try {
                        arredamentoService.delete(arredamentoEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getFornitureEntities().isEmpty()) {
                entity.getFornitureEntities().forEach(fornitureEntity -> {
                    try {
                        fornitureService.delete(fornitureEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getManutenzioneEntities().isEmpty()) {
                entity.getManutenzioneEntities().forEach(manutenzioneEntity -> {
                    try {
                        manutenzioneService.delete(manutenzioneEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getMiglioramentiEntities().isEmpty()) {
                entity.getMiglioramentiEntities().forEach(miglioramentiEntity -> {
                    try {
                        miglioramentiService.delete(miglioramentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getTraslocoEntities().isEmpty()) {
                entity.getTraslocoEntities().forEach(traslocoEntity -> {
                    try {
                        traslocoService.delete(traslocoEntity);
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
        affittoService.deleteAll();
        altroCasaService.deleteAll();
        arredamentoService.deleteAll();
        fornitureService.deleteAll();
        manutenzioneService.deleteAll();
        miglioramentiService.deleteAll();
        traslocoService.deleteAll();
        repository.deleteAll();
    }

    public void deleteAll(Iterable<CasaEntity> entities) {
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
        if (repository.existsById(id)) {
            if (!repository.findById(id).get().getAffittoEntities().isEmpty()) {
                repository.findById(id).get().getAffittoEntities().forEach(entity -> {
                    try {
                        affittoService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(entity -> {
                    try {
                        altroCasaService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getArredamentoEntities().isEmpty()) {
                repository.findById(id).get().getArredamentoEntities().forEach(entity -> {
                    try {
                        arredamentoService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getFornitureEntities().isEmpty()) {
                repository.findById(id).get().getFornitureEntities().forEach(entity -> {
                    try {
                        fornitureService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getManutenzioneEntities().isEmpty()) {
                repository.findById(id).get().getManutenzioneEntities().forEach(entity -> {
                    try {
                        manutenzioneService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getMiglioramentiEntities().isEmpty()) {
                repository.findById(id).get().getMiglioramentiEntities().forEach(entity -> {
                    try {
                        miglioramentiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getTraslocoEntities().isEmpty()) {
                repository.findById(id).get().getTraslocoEntities().forEach(entity -> {
                    try {
                        traslocoService.deleteById(entity.getId());
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
    public Iterable<CasaEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<CasaEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<CasaEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public CasaEntity save(CasaEntity entity) {
        affittoService.saveAll(entity.getAffittoEntities());
        altroCasaService.saveAll(entity.getAltroEntities());
        arredamentoService.saveAll(entity.getArredamentoEntities());
        fornitureService.saveAll(entity.getFornitureEntities());
        manutenzioneService.saveAll(entity.getManutenzioneEntities());
        miglioramentiService.saveAll(entity.getMiglioramentiEntities());
        traslocoService.saveAll(entity.getTraslocoEntities());
        return repository.save(entity);
    }

    public Iterable<CasaEntity> saveAll(Iterable<CasaEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
