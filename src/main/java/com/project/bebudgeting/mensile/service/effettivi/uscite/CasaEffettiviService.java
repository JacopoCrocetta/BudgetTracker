package com.project.bebudgeting.mensile.service.effettivi.uscite;

import com.project.bebudgeting.mensile.repository.effettivi.uscite.CasaEffettiviRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasaEffettiviService {
    @Autowired
    CasaEffettiviRepository repository;
}
