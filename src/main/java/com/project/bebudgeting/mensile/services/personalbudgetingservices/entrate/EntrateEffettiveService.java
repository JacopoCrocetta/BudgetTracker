package com.project.bebudgeting.mensile.services.personalbudgetingservices.entrate;


import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.*;
import com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.effettive.*;
import com.project.bebudgeting.utility.UtilityEntrate;
import javassist.NotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class EntrateEffettiveService {

    UtilityEntrate utility;

    @Autowired
    AltreCategorieEffettiveRepository categorieRepository;

    @Autowired
    BonusEffettiviRepository bonusEffettiviRepository;

    @Autowired
    BustaPagaEffettiviRepository bustaPagaEffettiviRepository;

    @Autowired
    InteressiEffettiviRepository interessiEffettiviRepository;

    @Autowired
    RisparmiEffettiviRepository risparmiEffettiviRepository;

    //FINDALL
    public EntrateEffettiveEntity getAllActualRevenue() {
        EntrateEffettiveEntity entrateEffettiveEntityList = new EntrateEffettiveEntity();
        entrateEffettiveEntityList.setAltreCategorieEntities(categorieRepository.findAll());
        entrateEffettiveEntityList.setBonusEntities(bonusEffettiviRepository.findAll());
        entrateEffettiveEntityList.setBustaPagaEntities(bustaPagaEffettiviRepository.findAll());
        entrateEffettiveEntityList.setInteressiEntities(interessiEffettiviRepository.findAll());
        entrateEffettiveEntityList.setRisparmiEntities(risparmiEffettiviRepository.findAll());
        return entrateEffettiveEntityList;
    }

    public EntrateEffettiveEntity getFilteredActualRevenueByDate(LocalDate startDate, LocalDate endDate) {
        EntrateEffettiveEntity ret = new EntrateEffettiveEntity();
        ret.setAltreCategorieEntities(utility.getFilteredCategorieEffettiveByDate(startDate, endDate, categorieRepository.findAll()));
        ret.setBonusEntities(utility.getFilteredBonusEffettiveByDate(startDate, endDate, bonusEffettiviRepository.findAll()));
        ret.setBustaPagaEntities(utility.getFilteredBustaPagaEffettiveByDate(startDate, endDate, bustaPagaEffettiviRepository.findAll()));
        ret.setInteressiEntities(utility.getFilteredInteressiEffettiveByDate(startDate, endDate, interessiEffettiviRepository.findAll()));
        ret.setRisparmiEntities(utility.getFilteredRisparmiEffettiveByDate(startDate, endDate, risparmiEffettiviRepository.findAll()));
        return ret;
    }

    //MEDIE
    public BigDecimal getAverageActualRevenueByDate(LocalDate startDate, LocalDate endDate) {
        return utility.getFilteredActualRevenueSum(getFilteredActualRevenueByDate(startDate, endDate)).divide(utility.getTotalForActualRevenueSum(getAllActualRevenue()));
    }

    public BigDecimal getFilteredSumActualRevenueByDate(LocalDate startDate, LocalDate endDate) {
        return utility.getFilteredActualRevenueSum(getFilteredActualRevenueByDate(startDate, endDate));
    }

    //FIND BY ID
    public EntrateEffettiveEntity findEntrateEffettiveElementByID(int id) {
        return utility.retreiveOneElementByID(id, new EntrateEffettiveEntity(), this.categorieRepository, this.bonusEffettiviRepository, this.bustaPagaEffettiviRepository, this.interessiEffettiviRepository, this.risparmiEffettiviRepository);
    }

    public AltreCategorieEntrateEffettiviEntity findAltreCategorieElementByID(int id) {
        return categorieRepository.findById(id).get();
    }

    public BonusEffettiveEntity findBonusEntityByID(int id) {
        return bonusEffettiviRepository.findById(id).get();
    }

    public BustaPagaEffettiveEntity findBustaPagaByID(int id) {
        return bustaPagaEffettiviRepository.findById(id).get();
    }

    public InteressiEffettiviEntity findInteressiByID(int id) {
        return interessiEffettiviRepository.findById(id).get();
    }

    //OPERAZIONI FONDAMENTALI
    //SAVE
    public EntrateEffettiveEntity addEntities(EntrateEffettiveEntity entitiesToAdd) {
        if (utility.hasOneElement(entitiesToAdd)) {
            return addOneEntity(entitiesToAdd);
        }
        categorieRepository.saveAll(entitiesToAdd.getAltreCategorieEntities());
        bonusEffettiviRepository.saveAll(entitiesToAdd.getBonusEntities());
        bustaPagaEffettiviRepository.saveAll(entitiesToAdd.getBustaPagaEntities());
        interessiEffettiviRepository.saveAll(entitiesToAdd.getInteressiEntities());
        risparmiEffettiviRepository.saveAll(entitiesToAdd.getRisparmiEntities());
        return entitiesToAdd;
    }

    public EntrateEffettiveEntity addOneEntity(EntrateEffettiveEntity entityToAdd) {
        if (!utility.hasOneElement(entityToAdd)) {
            return null;
        }
        categorieRepository.save(entityToAdd.getAltreCategorieEntities().get(0));
        bonusEffettiviRepository.save(entityToAdd.getBonusEntities().get(0));
        bustaPagaEffettiviRepository.save(entityToAdd.getBustaPagaEntities().get(0));
        interessiEffettiviRepository.save(entityToAdd.getInteressiEntities().get(0));
        risparmiEffettiviRepository.save(entityToAdd.getRisparmiEntities().get(0));
        return entityToAdd;
    }

    public AltreCategorieEntrateEffettiviEntity addOneEntity(AltreCategorieEntrateEffettiviEntity entityToAdd) {
        return categorieRepository.save(entityToAdd);
    }

    public BonusEffettiveEntity addOneEntity(BonusEffettiveEntity entityToAdd) {
        return bonusEffettiviRepository.save(entityToAdd);
    }

    public BustaPagaEffettiveEntity addOneEntity(BustaPagaEffettiveEntity entityToAdd) {
        return bustaPagaEffettiviRepository.save(entityToAdd);
    }

    public InteressiEffettiviEntity addOneEntity(InteressiEffettiviEntity entityToAdd) {
        return interessiEffettiviRepository.save(entityToAdd);
    }

    public RisparmiEffettiveEntity addOneEntity(RisparmiEffettiveEntity entityToAdd) {
        return risparmiEffettiviRepository.save(entityToAdd);
    }

    //DELETE ONE ELEMENT
    public void deleteOneEntity(EntrateEffettiveEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (utility.exists(entityToDelete, this.categorieRepository, this.bonusEffettiviRepository, this.bustaPagaEffettiviRepository, this.interessiEffettiviRepository, this.risparmiEffettiviRepository))
            utility.deleteOneElement(entityToDelete, this.categorieRepository, this.bonusEffettiviRepository, this.bustaPagaEffettiviRepository, this.interessiEffettiviRepository, this.risparmiEffettiviRepository);
        throw new NotFoundException("Item not found");
    }

    public void deleteOneEntity(AltreCategorieEntrateEffettiviEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (categorieRepository.existsById(entityToDelete.getId())) categorieRepository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    public void deleteOneEntity(BonusEffettiveEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (bonusEffettiviRepository.existsById(entityToDelete.getId()))
            bonusEffettiviRepository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    public void deleteOneEntity(BustaPagaEffettiveEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (bustaPagaEffettiviRepository.existsById(entityToDelete.getId()))
            bustaPagaEffettiviRepository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    public void deleteOneEntity(InteressiEffettiviEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (interessiEffettiviRepository.existsById(entityToDelete.getId()))
            interessiEffettiviRepository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    public void deleteOneEntity(RisparmiEffettiveEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (risparmiEffettiviRepository.existsById(entityToDelete.getId()))
            risparmiEffettiviRepository.delete(entityToDelete);
        throw new NotFoundException("Item not found");
    }

    //DELETE ALL
    public void deleteAllEntity() {
        categorieRepository.deleteAll();
        bonusEffettiviRepository.deleteAll();
        bustaPagaEffettiviRepository.deleteAll();
        interessiEffettiviRepository.deleteAll();
        risparmiEffettiviRepository.deleteAll();
    }

    public void deleteAllCategorieEntity() {
        categorieRepository.deleteAll();
    }

    public void deleteAllBonusEntity() {
        bonusEffettiviRepository.deleteAll();
    }

    public void deleteAllInteressiEntity() {
        interessiEffettiviRepository.deleteAll();
    }

    public void deleteAllRisparmiEntity() {
        risparmiEffettiviRepository.deleteAll();
    }

    //DELETE BY ID
    public void deleteCategorieEntityById(int id) throws NotFoundException {
        if (categorieRepository.existsById(id)) categorieRepository.deleteById(id);
        throw new NotFoundException("Item not found");
    }

    public void deleteBonusEntityById(int id) throws NotFoundException {
        if (bonusEffettiviRepository.existsById(id)) bonusEffettiviRepository.deleteById(id);
        throw new NotFoundException("Item not found");
    }

    public void deleteInteressiEntityById(int id) throws NotFoundException {
        if (interessiEffettiviRepository.existsById(id)) interessiEffettiviRepository.deleteById(id);
        throw new NotFoundException("Item not found");
    }

    public void deleteRisparmiEntityById(int id) throws NotFoundException {
        if (risparmiEffettiviRepository.existsById(id)) risparmiEffettiviRepository.deleteById(id);
        throw new NotFoundException("Item not found");
    }
}
