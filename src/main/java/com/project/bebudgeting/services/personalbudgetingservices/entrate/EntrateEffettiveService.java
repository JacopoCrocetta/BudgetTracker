package com.project.bebudgeting.services.personalbudgetingservices.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.effettive.*;
import com.project.bebudgeting.utility.UtilityEntrate;
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

    // OPERAZIONI SU ENTRATE EFFETTIVE
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

    public BigDecimal getAverageActualRevenueByDate(LocalDate startDate, LocalDate endDate) {
        return utility.getFilteredActualRevenueSum(getFilteredActualRevenueByDate(startDate, endDate)).divide(utility.getTotalForActualRevenueSum(getAllActualRevenue()));
    }

    public BigDecimal getFilteredSumActualRevenueByDate(LocalDate startDate, LocalDate endDate) {
        return utility.getFilteredActualRevenueSum(getFilteredActualRevenueByDate(startDate, endDate));
    }
}
