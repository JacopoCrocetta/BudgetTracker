package com.project.bebudgeting.services.personalbudgetingservices.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.repositories.personalbudgetrepositories.entrate.*;
import com.project.bebudgeting.utility.UtilityEntrate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class EntrateService {

    UtilityEntrate utility;

    @Autowired
    AltreCategorieRepository categorieRepository;

    @Autowired
    BonusRepository bonusRepository;

    @Autowired
    BustaPagaRepository bustaPagaRepository;

    @Autowired
    InteressiRepository interessiRepository;

    @Autowired
    RisparmiRepository risparmiRepository;

    public EntrateEffettiveEntity getAllEntrate() {
        EntrateEffettiveEntity entrateEffettiveEntityList = new EntrateEffettiveEntity();
        entrateEffettiveEntityList.setAltreCategorieEntities(categorieRepository.findAll());
        entrateEffettiveEntityList.setBonusEntities(bonusRepository.findAll());
        entrateEffettiveEntityList.setBustaPagaEntities(bustaPagaRepository.findAll());
        entrateEffettiveEntityList.setInteressiEntities(interessiRepository.findAll());
        entrateEffettiveEntityList.setRisparmiEntities(risparmiRepository.findAll());
        return entrateEffettiveEntityList;
    }

    public EntrateEffettiveEntity getFilteredEntriesByDate(LocalDate startDate, LocalDate endDate){
        EntrateEffettiveEntity ret = new EntrateEffettiveEntity();
        ret.setAltreCategorieEntities(utility.getFilteredCategorieByDate(startDate, endDate, categorieRepository.findAll()));
        ret.setBonusEntities(utility.getFilteredBonusByDate(startDate, endDate, bonusRepository.findAll()));
        ret.setBustaPagaEntities(utility.getFilteredBustaPagaByDate(startDate, endDate,bustaPagaRepository.findAll()));
        ret.setInteressiEntities(utility.getFilteredInteressiByDate(startDate, endDate,interessiRepository.findAll()));
        ret.setRisparmiEntities(utility.getFilteredRisparmiByDate(startDate, endDate,risparmiRepository.findAll()));
        return ret;
    }

    public BigDecimal getAverageEntriesByDate(LocalDate startDate, LocalDate endDate){
        return utility.getFilteredSum(getFilteredEntriesByDate(startDate, endDate)).divide(utility.getTotalSUm(getAllEntrate()));
    }

    public BigDecimal getFilteredSumByDate(LocalDate startDate, LocalDate endDate){
        return utility.getFilteredSum(getFilteredEntriesByDate(startDate, endDate));
    }
}
