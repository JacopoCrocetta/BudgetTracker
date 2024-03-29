package com.project.bebudgeting.service.mensili.effettivi;

import java.util.Optional;

import com.project.bebudgeting.entity.mensili.effettivi.EntrateEffettiveEntity;
import com.project.bebudgeting.repository.mensili.effettivimensili.EntrateEffettiveRepository;
import com.project.bebudgeting.service.mensili.effettivi.entrate.AltreEntrateEffettiveService;
import com.project.bebudgeting.service.mensili.effettivi.entrate.BonusEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.entrate.BustaPagaEffettiveService;
import com.project.bebudgeting.service.mensili.effettivi.entrate.InteressiEffettiviService;
import com.project.bebudgeting.service.mensili.effettivi.entrate.RisparmiEffettiviService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class EntrateEffettiveService {
    @Autowired
    EntrateEffettiveRepository repository;

    @Autowired
    AltreEntrateEffettiveService altreEntrateEffettiveService;

    @Autowired
    BonusEffettiviService bonusEffettiviService;

    @Autowired
    BustaPagaEffettiveService bustaPagaEffettiveService;

    @Autowired
    InteressiEffettiviService interessiEffettiviService;

    @Autowired
    RisparmiEffettiviService risparmiEffettiviService;

    /**
     * @return long
     */
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

    /**
     * @param entity
     * @throws NotFoundException
     */
    public void delete(EntrateEffettiveEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            entity.getAltreEntrateEffettiveEntities().forEach(altreEntrateEntity -> {
                if (altreEntrateEffettiveService.findById(altreEntrateEntity.getId()).isPresent()) {
                    try {
                        altreEntrateEffettiveService.delete(altreEntrateEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBonusEffettiviEntities().forEach(bonusEntity -> {
                if (bonusEffettiviService.findById(bonusEntity.getId()).isPresent()) {
                    try {
                        bonusEffettiviService.delete(bonusEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getBustaPagaEffettiveEntities().forEach(bustaPagaEntity -> {
                if (bustaPagaEffettiveService.findById(bustaPagaEntity.getId()).isPresent()) {
                    try {
                        bustaPagaEffettiveService.delete(bustaPagaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getInteressiEffettiviEntities().forEach(interessiEntity -> {
                if (interessiEffettiviService.findById(interessiEntity.getId()).isPresent()) {
                    try {
                        interessiEffettiviService.delete(interessiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            entity.getRisparmiEffettiviEntities().forEach(risparmiEntity -> {
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

    /**
     * @param id
     * @throws NotFoundException
     */
    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            repository.findById(id).get().getAltreEntrateEffettiveEntities().forEach(altreEntrateEntity -> {
                if (altreEntrateEffettiveService.findById(altreEntrateEntity.getId()).isPresent()) {
                    try {
                        altreEntrateEffettiveService.delete(altreEntrateEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBonusEffettiviEntities().forEach(bonusEntity -> {
                if (bonusEffettiviService.findById(bonusEntity.getId()).isPresent()) {
                    try {
                        bonusEffettiviService.delete(bonusEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getBustaPagaEffettiveEntities().forEach(bustaPagaEntity -> {
                if (bustaPagaEffettiveService.findById(bustaPagaEntity.getId()).isPresent()) {
                    try {
                        bustaPagaEffettiveService.delete(bustaPagaEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getInteressiEffettiviEntities().forEach(interessiEntity -> {
                if (interessiEffettiviService.findById(interessiEntity.getId()).isPresent()) {
                    try {
                        interessiEffettiviService.delete(interessiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            repository.findById(id).get().getRisparmiEffettiviEntities().forEach(risparmiEntity -> {
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

    /**
     * @param entities
     */
    public void deleteAll(Iterable<EntrateEffettiveEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param ids
     */
    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return Iterable<EntrateEffettiveEntity>
     */
    // FIND
    public Iterable<EntrateEffettiveEntity> findAll() {
        return repository.findAll();
    }

    /**
     * @param ids
     * @return Iterable<EntrateEffettiveEntity>
     */
    public Iterable<EntrateEffettiveEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    /**
     * @param id
     * @return Optional<EntrateEffettiveEntity>
     */
    public Optional<EntrateEffettiveEntity> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return EntrateEffettiveEntity
     */
    // SAVE
    public EntrateEffettiveEntity save(EntrateEffettiveEntity entity) {
        altreEntrateEffettiveService.saveAll(entity.getAltreEntrateEffettiveEntities());
        bonusEffettiviService.saveAll(entity.getBonusEffettiviEntities());
        bustaPagaEffettiveService.saveAll(entity.getBustaPagaEffettiveEntities());
        interessiEffettiviService.saveAll(entity.getInteressiEffettiviEntities());
        risparmiEffettiviService.saveAll(entity.getRisparmiEffettiviEntities());
        return repository.save(entity);
    }

    /**
     * @param entities
     * @return Iterable<EntrateEffettiveEntity>
     */
    public Iterable<EntrateEffettiveEntity> saveAll(Iterable<EntrateEffettiveEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
