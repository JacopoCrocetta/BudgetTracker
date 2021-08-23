package com.project.bebudgeting.mensile.service.previsti;

import java.util.Optional;

import com.project.bebudgeting.mensile.entity.previsti.EntratePrevisteEntity;
import com.project.bebudgeting.mensile.repository.previsti.EntratePrevisteRepository;
import com.project.bebudgeting.mensile.service.previsti.entrate.AltreEntratePrevisteService;
import com.project.bebudgeting.mensile.service.previsti.entrate.BonusPrevistiService;
import com.project.bebudgeting.mensile.service.previsti.entrate.BustaPagaPrevisteService;
import com.project.bebudgeting.mensile.service.previsti.entrate.InteressiPrevistiService;
import com.project.bebudgeting.mensile.service.previsti.entrate.RisparmiPrevistiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EntratePrevisteService {
    @Autowired
    EntratePrevisteRepository repository;

    @Autowired
    AltreEntratePrevisteService altreEntrateEffettiveService;

    @Autowired
    BonusPrevistiService bonusEffettiviService;

    @Autowired
    BustaPagaPrevisteService bustaPagaEffettiveService;

    @Autowired
    InteressiPrevistiService interessiEffettiviService;

    @Autowired
    RisparmiPrevistiService risparmiEffettiviService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altreEntrateEffettiveService.deleteAll();
        bonusEffettiviService.deleteAll();
        bustaPagaEffettiveService.deleteAll();
        interessiEffettiviService.deleteAll();
        risparmiEffettiviService.deleteAll();
        repository.deleteAll();
    }

    public void delete(EntratePrevisteEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            entity.getAltreEntratePrevisteEntities().forEach(altreEntrateEntity -> {
                if (altreEntrateEffettiveService.findById(altreEntrateEntity.getId()).isPresent()) {
                    try {
                        altreEntrateEffettiveService.delete(altreEntrateEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBonusPrevistiEntities().forEach(bonusEntity -> {
                if (bonusEffettiviService.findById(bonusEntity.getId()).isPresent()) {
                    try {
                        bonusEffettiviService.delete(bonusEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBustaPagaPrevisteEntities().forEach(bustaPagaEntity -> {
                if (bustaPagaEffettiveService.findById(bustaPagaEntity.getId()).isPresent()) {
                    try {
                        bustaPagaEffettiveService.delete(bustaPagaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getInteressiPrevistiEntities().forEach(interessiEntity -> {
                if (interessiEffettiviService.findById(interessiEntity.getId()).isPresent()) {
                    try {
                        interessiEffettiviService.delete(interessiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getRisparmiPrevistiEntities().forEach(risparmiEntity -> {
                if (risparmiEffettiviService.findById(risparmiEntity.getId()).isPresent()) {
                    try {
                        risparmiEffettiviService.delete(risparmiEntity);
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
                if (altreEntrateEffettiveService.findById(altreEntrateEntity.getId()).isPresent()) {
                    try {
                        altreEntrateEffettiveService.delete(altreEntrateEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBonusPrevistiEntities().forEach(bonusEntity -> {
                if (bonusEffettiviService.findById(bonusEntity.getId()).isPresent()) {
                    try {
                        bonusEffettiviService.delete(bonusEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBustaPagaPrevisteEntities().forEach(bustaPagaEntity -> {
                if (bustaPagaEffettiveService.findById(bustaPagaEntity.getId()).isPresent()) {
                    try {
                        bustaPagaEffettiveService.delete(bustaPagaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getInteressiPrevistiEntities().forEach(interessiEntity -> {
                if (interessiEffettiviService.findById(interessiEntity.getId()).isPresent()) {
                    try {
                        interessiEffettiviService.delete(interessiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getRisparmiPrevistiEntities().forEach(risparmiEntity -> {
                if (risparmiEffettiviService.findById(risparmiEntity.getId()).isPresent()) {
                    try {
                        risparmiEffettiviService.delete(risparmiEntity);
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
        altreEntrateEffettiveService.saveAll(entity.getAltreEntratePrevisteEntities());
        bonusEffettiviService.saveAll(entity.getBonusPrevistiEntities());
        bustaPagaEffettiveService.saveAll(entity.getBustaPagaPrevisteEntities());
        interessiEffettiviService.saveAll(entity.getInteressiPrevistiEntities());
        risparmiEffettiviService.saveAll(entity.getRisparmiPrevistiEntities());
        return repository.save(entity);
    }

    public Iterable<EntratePrevisteEntity> saveAll(Iterable<EntratePrevisteEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
