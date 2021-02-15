package com.project.bebudgeting.services.personalbudgetingservices.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntratePrevisteEntity;
import com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.previste.*;
import com.project.bebudgeting.utility.UtilityEntrate;
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
}
