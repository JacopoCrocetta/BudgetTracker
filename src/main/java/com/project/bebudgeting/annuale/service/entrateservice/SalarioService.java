package com.project.bebudgeting.annuale.service.entrateservice;

import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;
import com.project.bebudgeting.annuale.repository.entrateannuali.SalarioRepository;
import com.project.bebudgeting.annuale.service.entrateservice.dettagliosalarioservice.*;
import javassist.NotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    ManceService manceService;

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
        entities.forEach(entity -> {
            if (!entity.getAltroEntities().isEmpty()) {
                altroSalarioService.deleteAll(entity.getAltroEntities());
            }
            if (!entity.getBonusEntities().isEmpty()) {
                bonusService.deleteAll(entity.getBonusEntities());
            }
            if (!entity.getBustaPagaEntities().isEmpty()) {
                bustaPagaService.deleteAll(entity.getBustaPagaEntities());
            }
            if (!entity.getCommissioniEntities().isEmpty()) {
                commissioniService.deleteAll(entity.getCommissioniEntities());
            }
            if (!entity.getManceEntities().isEmpty()) {
                manceService.deleteAll(entity.getManceEntities());
            }
        });
        repository.deleteAll(entities);
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroSalarioService.deleteById(altroEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }

                });
            }
            if (!repository.findById(id).get().getBonusEntities().isEmpty()) {
                repository.findById(id).get().getBonusEntities().forEach(bonusEntity -> {
                    try {
                        bonusService.deleteById(bonusEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getBustaPagaEntities().isEmpty()) {
                repository.findById(id).get().getBustaPagaEntities().forEach(bustaPagaEntities -> {
                    try {
                        bustaPagaService.deleteById(bustaPagaEntities.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getCommissioniEntities().isEmpty()) {
                repository.findById(id).get().getCommissioniEntities().forEach(commissioniEntity -> {
                    try {
                        commissioniService.deleteById(commissioniEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getManceEntities().isEmpty()) {
                repository.findById(id).get().getManceEntities().forEach(manceEntity -> {
                    try {
                        manceService.deleteById(manceEntity.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
            }
            repository.deleteById(id);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void delete(SalarioEntity entityToDelete)
            throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) {
            throw new NullPointerException("Item is not set");
        }
        if (!repository.findById(entityToDelete.getId()).isPresent()) {
            throw new NotFoundException("Item is not set");
        }
        if (!entityToDelete.getAltroEntities().isEmpty()) {
            entityToDelete.getAltroEntities().forEach(altroEntity -> {
                try {
                    altroSalarioService.delete(altroEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        if (!entityToDelete.getBonusEntities().isEmpty()) {
            entityToDelete.getBonusEntities().forEach(bonusEntity -> {
                try {
                    bonusService.delete(bonusEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        if (!entityToDelete.getBustaPagaEntities().isEmpty()) {
            entityToDelete.getBustaPagaEntities().forEach(bustaPagaEntity -> {
                try {
                    bustaPagaService.delete(bustaPagaEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        if (!entityToDelete.getCommissioniEntities().isEmpty()) {
            entityToDelete.getCommissioniEntities().forEach(commissioniEntity -> {
                try {
                    commissioniService.delete(commissioniEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        if (!entityToDelete.getManceEntities().isEmpty()) {
            entityToDelete.getManceEntities().forEach(manceEntity -> {
                try {
                    manceService.delete(manceEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        repository.delete(entityToDelete);
    }

    // SAVE
    public SalarioEntity save(SalarioEntity entityToSave) {
        if (!entityToSave.getAltroEntities().isEmpty()) {
            altroSalarioService.saveAll(entityToSave.getAltroEntities());
        }
        if (!entityToSave.getBonusEntities().isEmpty()) {
            bonusService.saveAll(entityToSave.getBonusEntities());
        }
        if (!entityToSave.getBustaPagaEntities().isEmpty()) {
            bustaPagaService.saveAll(entityToSave.getBustaPagaEntities());
        }
        if (!entityToSave.getCommissioniEntities().isEmpty()) {
            commissioniService.saveAll(entityToSave.getCommissioniEntities());
        }
        if (!entityToSave.getManceEntities().isEmpty()) {
            manceService.saveAll(entityToSave.getManceEntities());
        }
        return repository.save(entityToSave);
    }

    public Iterable<SalarioEntity> saveAll(Iterable<SalarioEntity> entitiesToSave) {
        entitiesToSave.forEach(entityToSave -> {
            this.save(entityToSave);
        });
        return entitiesToSave;
    }
}
