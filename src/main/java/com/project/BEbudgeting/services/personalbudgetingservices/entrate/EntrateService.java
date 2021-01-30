package com.project.BEbudgeting.services.personalbudgetingservices.entrate;

import com.project.BEbudgeting.entities.personalbudgetingentity.EntrateEntity;
import com.project.BEbudgeting.repositories.personalbudgetrepositories.EntrateRepository;
import com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate.AltreCategorieRepository;
import com.project.BEbudgeting.repositories.personalbudgetrepositories.entrate.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrateService {

    @Autowired
    EntrateRepository entrateRepository;

    @Autowired
    AltreCategorieRepository categorieRepository;

    @Autowired
    BonusRepository bonusRepository;

    public Iterable<EntrateEntity> getAllEntrate(){
        return entrateRepository.findAll();
    } //Questo non so se effettivamente funziona
}
