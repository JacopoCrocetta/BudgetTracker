package com.project.bebudgeting.annuale.service;

import com.project.bebudgeting.annuale.repository.entrateannuali.AltreEntrateRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositorydettaglisalario.AltroSalarioRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.SalarioRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.AltroERepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.DividendiRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.InteressiRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.RegaliRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.RimborsiRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.repositoryaltreentrate.TrasferimentoRisparmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrateBudgetService {
    @Autowired
    SalarioRepository salarioRepository;

    @Autowired
    AltreEntrateRepository altreEntrateRepository;

    @Autowired
    AltroERepository altroERepository;

    @Autowired
    DividendiRepository dividendiRepository;

    @Autowired
    InteressiRepository interessiRepository;

    @Autowired
    RegaliRepository regaliRepository;

    @Autowired
    RimborsiRepository rimborsiRepository;

    @Autowired
    TrasferimentoRisparmiRepository trasferimentoRisparmiRepository;

    @Autowired
    AltroSalarioRepository altroSRepository;
}