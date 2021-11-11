package com.project.bebudgeting.service.mensili.previsti;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.previsti.EntratePrevisteEntity;
import com.project.bebudgeting.repository.mensili.previstimensili.EntratePrevisteRepository;
import com.project.bebudgeting.service.mensili.previsti.entrate.AltreEntratePrevisteService;
import com.project.bebudgeting.service.mensili.previsti.entrate.BonusPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.entrate.BustaPagaPrevisteService;
import com.project.bebudgeting.service.mensili.previsti.entrate.InteressiPrevistiService;
import com.project.bebudgeting.service.mensili.previsti.entrate.RisparmiPrevistiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EntratePrevisteService {
    @Autowired
    EntratePrevisteRepository repository;

    @Autowired
    AltreEntratePrevisteService altreEntratePrevisteService;

    @Autowired
    BonusPrevistiService bonusPrevistiService;

    @Autowired
    BustaPagaPrevisteService bustaPagaPrevisteService;

    @Autowired
    InteressiPrevistiService interessiPrevistiService;

    @Autowired
    RisparmiPrevistiService risparmiPrevistiService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altreEntratePrevisteService.deleteAll();
        bonusPrevistiService.deleteAll();
        bustaPagaPrevisteService.deleteAll();
        interessiPrevistiService.deleteAll();
        risparmiPrevistiService.deleteAll();
        repository.deleteAll();
    }

    public void delete(EntratePrevisteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            entity.getAltreEntratePrevisteEntities().forEach(altreEntrateEntity -> {
                if (altreEntratePrevisteService.findById(altreEntrateEntity.getId()).isPresent()) {
                    try {
                        altreEntratePrevisteService.delete(altreEntrateEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBonusPrevistiEntities().forEach(bonusEntity -> {
                if (bonusPrevistiService.findById(bonusEntity.getId()).isPresent()) {
                    try {
                        bonusPrevistiService.delete(bonusEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBustaPagaPrevisteEntities().forEach(bustaPagaEntity -> {
                if (bustaPagaPrevisteService.findById(bustaPagaEntity.getId()).isPresent()) {
                    try {
                        bustaPagaPrevisteService.delete(bustaPagaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getInteressiPrevistiEntities().forEach(interessiEntity -> {
                if (interessiPrevistiService.findById(interessiEntity.getId()).isPresent()) {
                    try {
                        interessiPrevistiService.delete(interessiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getRisparmiPrevistiEntities().forEach(risparmiEntity -> {
                if (risparmiPrevistiService.findById(risparmiEntity.getId()).isPresent()) {
                    try {
                        risparmiPrevistiService.delete(risparmiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.findById(id).get().getAltreEntratePrevisteEntities().forEach(altreEntrateEntity -> {
                if (altreEntratePrevisteService.findById(altreEntrateEntity.getId()).isPresent()) {
                    try {
                        altreEntratePrevisteService.delete(altreEntrateEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBonusPrevistiEntities().forEach(bonusEntity -> {
                if (bonusPrevistiService.findById(bonusEntity.getId()).isPresent()) {
                    try {
                        bonusPrevistiService.delete(bonusEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBustaPagaPrevisteEntities().forEach(bustaPagaEntity -> {
                if (bustaPagaPrevisteService.findById(bustaPagaEntity.getId()).isPresent()) {
                    try {
                        bustaPagaPrevisteService.delete(bustaPagaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getInteressiPrevistiEntities().forEach(interessiEntity -> {
                if (interessiPrevistiService.findById(interessiEntity.getId()).isPresent()) {
                    try {
                        interessiPrevistiService.delete(interessiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getRisparmiPrevistiEntities().forEach(risparmiEntity -> {
                if (risparmiPrevistiService.findById(risparmiEntity.getId()).isPresent()) {
                    try {
                        risparmiPrevistiService.delete(risparmiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<EntratePrevisteEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
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
    public Iterable<EntratePrevisteEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<EntratePrevisteEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<EntratePrevisteEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public EntratePrevisteEntity save(EntratePrevisteEntity entity) {
        altreEntratePrevisteService.saveAll(entity.getAltreEntratePrevisteEntities());
        bonusPrevistiService.saveAll(entity.getBonusPrevistiEntities());
        bustaPagaPrevisteService.saveAll(entity.getBustaPagaPrevisteEntities());
        interessiPrevistiService.saveAll(entity.getInteressiPrevistiEntities());
        risparmiPrevistiService.saveAll(entity.getRisparmiPrevistiEntities());
        return repository.save(entity);
    }

    public Iterable<EntratePrevisteEntity> saveAll(Iterable<EntratePrevisteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
