package com.project.BEbudgeting.services.personalbudgetingservices.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.EntrateEntity;
import com.project.BEbudgeting.repositories.personalbudgetrepositories.EntrateRepository;
import com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrateService {

    @Autowired
    EntrateRepository entrateRepository; // DA VEDERE SE EFFETTIVAMENTE SERVE

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

    public EntrateEntity getAllEntrate() {
        EntrateEntity entrateEntityList = new EntrateEntity();
        entrateEntityList.setAltreCategorieEntities(categorieRepository.findAll());
        entrateEntityList.setBonusEntities(bonusRepository.findAll());
        entrateEntityList.setBustaPagaEntities(bustaPagaRepository.findAll());
        entrateEntityList.setInteressiEntities(interessiRepository.findAll());
        entrateEntityList.setRisparmiEntities(risparmiRepository.findAll());
        return entrateEntityList;
    }
}
