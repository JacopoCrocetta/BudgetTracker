package com.project.bebudgeting.mensile.services.personalbudgetingservices.entrate;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.EntratePrevisteEntity;
import com.project.bebudgeting.mensile.repositories.personalbudgetrepositories.entrate.previste.*;
import com.project.bebudgeting.utility.UtilityEntrate;
import javassist.NotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class EntratePrevisteService {

    UtilityEntrate utility;

    @Autowired
    AltreCategoriePrevisteRepository categorieRepository;

    @Autowired
    BonusPrevistiRepository bonusRepository;

    @Autowired
    BustaPagaPrevistiRepository bustaPagaRepository;

    @Autowired
    InteressiPrevistiRepository interessiRepository;

    @Autowired
    RisparmiPrevistiRepository risparmiRepository;

    //OPERAZIONI SU ENTRATE PREVISTE
    public EntratePrevisteEntity getAllEstimatedRevenue() {
        EntratePrevisteEntity entratePrevisteEntityList = new EntratePrevisteEntity();
        entratePrevisteEntityList.setAltreCategorieEntities(categorieRepository.findAll());
        entratePrevisteEntityList.setBonusEntities(bonusRepository.findAll());
        entratePrevisteEntityList.setBustaPagaEntities(bustaPagaRepository.findAll());
        entratePrevisteEntityList.setInteressiEntities(interessiRepository.findAll());
        entratePrevisteEntityList.setRisparmiEntities(risparmiRepository.findAll());
        return entratePrevisteEntityList;
    }

    public EntratePrevisteEntity getFilteredEstimatedRevenueByDate(LocalDate startDate, LocalDate endDate) {
        EntratePrevisteEntity filteredEstimatedRevenueList = new EntratePrevisteEntity();
        filteredEstimatedRevenueList.setAltreCategorieEntities(utility.getFilteredCategoriePrevisteByDate(startDate, endDate, categorieRepository.findAll()));
        filteredEstimatedRevenueList.setBonusEntities(utility.getFilteredBonusPrevistiByDate(startDate, endDate, bonusRepository.findAll()));
        filteredEstimatedRevenueList.setBustaPagaEntities(utility.getFilteredBustaPagaPrevisteByDate(startDate, endDate, bustaPagaRepository.findAll()));
        filteredEstimatedRevenueList.setInteressiEntities(utility.getFilteredInteressiPrevistiByDate(startDate, endDate, interessiRepository.findAll()));
        filteredEstimatedRevenueList.setRisparmiEntities(utility.getFilteredRisparmiPrevistiByDate(startDate, endDate, risparmiRepository.findAll()));
        return filteredEstimatedRevenueList;
    }

    public BigDecimal getAverageEstimatedRevenueByDate(LocalDate startDate, LocalDate endDate) {
        return utility.getFilteredEstimatedRevenue(getFilteredEstimatedRevenueByDate(startDate, endDate)).divide(utility.getTotalEstimatedRevenueSum(getAllEstimatedRevenue()));
    }

    public BigDecimal getFilteredSumEstimatedRevenueByDate(LocalDate startDate, LocalDate endDate) {
        return utility.getFilteredEstimatedRevenue(getFilteredEstimatedRevenueByDate(startDate, endDate));
    }

    public BigDecimal getPercentageRevenue() {
        return (utility.getTotalForActualRevenueSum((new EntrateEffettiveService()).getAllActualRevenue()).divide(utility.getTotalEstimatedRevenueSum(this.getAllEstimatedRevenue()))).multiply(new BigDecimal("100"));
    }

    //OPERAZIONI FONDAMENTALI
    public EntratePrevisteEntity addEntities(EntratePrevisteEntity entitiesToAdd) {
        if (utility.hasOneElement(entitiesToAdd)) {
            return addOneEntity(entitiesToAdd);
        }
        categorieRepository.saveAll(entitiesToAdd.getAltreCategorieEntities());
        bonusRepository.saveAll(entitiesToAdd.getBonusEntities());
        bustaPagaRepository.saveAll(entitiesToAdd.getBustaPagaEntities());
        interessiRepository.saveAll(entitiesToAdd.getInteressiEntities());
        risparmiRepository.saveAll(entitiesToAdd.getRisparmiEntities());
        return entitiesToAdd;
    }

    public EntratePrevisteEntity addOneEntity(EntratePrevisteEntity entityToAdd) {
        if (!utility.hasOneElement(entityToAdd)) {
            return null;
        }
        categorieRepository.save(entityToAdd.getAltreCategorieEntities().get(0));
        bonusRepository.save(entityToAdd.getBonusEntities().get(0));
        bustaPagaRepository.save(entityToAdd.getBustaPagaEntities().get(0));
        interessiRepository.save(entityToAdd.getInteressiEntities().get(0));
        risparmiRepository.save(entityToAdd.getRisparmiEntities().get(0));
        return entityToAdd;
    }

    public void deleteOneEntity(EntratePrevisteEntity entityToDelete) throws NotFoundException, NullPointerException, NotImplementedException {
        if (entityToDelete == null) throw new NullPointerException("Item is not set");
        if (utility.exists(entityToDelete, this.categorieRepository, this.bonusRepository, this.bustaPagaRepository, this.interessiRepository, this.risparmiRepository))
            utility.deleteOneElement(entityToDelete, this.categorieRepository, this.bonusRepository, this.bustaPagaRepository, this.interessiRepository, this.risparmiRepository);
        throw new NotFoundException("Item not found");
    }
}
