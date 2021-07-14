package com.project.bebudgeting.annuale.service;

import com.project.bebudgeting.annuale.repository.entrateannuali.AltreEntrateRepository;
import com.project.bebudgeting.annuale.repository.entrateannuali.SalarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrateBudgetService {
    @Autowired
    SalarioRepository salarioRepository;

    @Autowired
    AltreEntrateRepository altreEntrateRepository;
}